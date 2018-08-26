package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit

import scala.collection.immutable.Queue
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.stm._

import java.util.concurrent.atomic._

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class DuctTest extends Zero.Syntax {

  /*
   * [info] Benchmark      Mode  Cnt     Score      Error  Units
   * [info] DuctTest.stm   avgt   30   906.968 ±  408.605  ns/op
   * [info] DuctTest.sync  avgt   30  1861.960 ± 1239.802  ns/op
   */

  type ReceiveAsync = PartialFunction[Any, Future[Any]]

  trait DuctSTM {

    // implement async behaviour here
    protected val process: ReceiveAsync

    case class State(busy: Boolean, queue: Queue[Any]) {
      def enqueue(msg: Any) = copy(queue = queue enqueue msg)
    }

    def !(msg: Any): Unit =
      if (!stateRef.single.getAndTransform { state =>
        if (state.busy) state enqueue msg
        else state.copy(busy = true)
      }.busy) run(msg)

    private[this] val stateRef = Ref(State(false, Queue.empty))

    private[this] def run(msg: Any): Unit =
      process.applyOrElse(msg, fallback) onComplete { _ => postRun }

    private[this] def postRun =
      stateRef.single.getAndTransform { state =>
        if (state.queue.isEmpty) state.copy(busy = false)
        else state.copy(queue = state.queue.tail)
      }.queue.headOption foreach run
  }

  trait DuctSynchronized {

    // implement async behaviour here
    protected val process: ReceiveAsync

    def !(msg: Any): Unit = this.synchronized {
      current = current flatMap {_ => run(msg) }
    }

    private[this] var current: Future[Any] = Future.successful(())

    private[this] def run(msg: Any): Future[Any] =
      process.applyOrElse(msg, fallback).recover { case _ => () }
  }

  val fallback = { msg: Any =>
    Future(())
  }

  val processTrue: ReceiveAsync = {
    case true => Future(true) // Async result
  }

  trait DuctAtomicNull {
    // implement async behaviour here
    protected val process: ReceiveAsync

    def !(msg: Any): Unit =
      if (state.getAndUpdate {
        case null => Queue.empty
        case q => q enqueue msg
      } == null) run(msg)

    def queueSize = state.get match {
      case null => 0
      case q => q.size + 1
    }

    /*
     * Queue contains msg currently processing, as well as backlog.
     * Idle: null
     * Busy: queue.isEmpty
     * Busy with backlog: queue.size > 0
     */
    private[this] val state: AtomicReference[Queue[Any]] = new AtomicReference()

    private[this] def run(msg: Any): Unit =
      process.applyOrElse(msg, fallback) onComplete postRun

    private[this] val postRun = (_: Any) =>
      state.getAndUpdate { q =>
        if (q.isEmpty) null
        else q.tail
      }.headOption foreach run
  }

  trait DuctAtomic {
    // implement async behaviour here
    protected val process: ReceiveAsync

    def !(msg: Any): Unit =
      if (state.getAndUpdate { _ enqueue msg } isEmpty) run(msg)

    def queueSize = state.get.size

    /*
     * Queue contains msg currently processing, as well as backlog.
     * Idle: null
     * Busy: queue.isEmpty
     * Busy with backlog: queue.size > 0
     */
    private[this] val state: AtomicReference[Queue[Any]] = new AtomicReference(Queue.empty)

    private[this] def run(msg: Any): Unit =
      process.applyOrElse(msg, fallback) onComplete postRun

    private[this] val postRun = (_: Any) =>
      state.updateAndGet(_.tail).headOption foreach run
  }



  val ductSTM = new DuctSTM { val process = processTrue }
  val ductSynchronized = new DuctSynchronized { val process = processTrue }

  val ductAtomic = new DuctAtomic { val process = processTrue }
  val ductAtomicNull = new DuctAtomicNull { val process = processTrue }


  @Benchmark
  def stm = ductSTM ! true

  @Benchmark
  def sync = ductSynchronized ! true

  @Benchmark
  def atomic = ductAtomic ! true

  @Benchmark
  def atomicNull = ductAtomicNull ! true
}
