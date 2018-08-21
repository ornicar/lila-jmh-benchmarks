package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit

import scala.collection.immutable.Queue
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.stm._

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

    def !(msg: Any): Unit = atomic { implicit txn =>
      stateRef.transform { state =>
        if (state.busy) state enqueue msg
        else {
          Txn.afterCommit { _ => run(msg) }
          state.copy(busy = true)
        }
      }
    }

    private[this] val stateRef = Ref(State(false, Queue.empty))

    private[this] def run(msg: Any): Unit =
      process.applyOrElse(msg, fallback) onComplete { _ => postRun }

    private[this] def postRun = atomic { implicit txn =>
      stateRef.transform { state =>
        state.queue.dequeueOption match {
          case None => state.copy(busy = false)
          case Some((msg, newQueue)) =>
            Txn.afterCommit { _ => run(msg) }
            State(true, newQueue)
        }
      }
    }
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
    case true => Future.successful(true)
  }

  val ductSTM = new DuctSTM { val process = processTrue }
  val ductSynchronized = new DuctSynchronized { val process = processTrue }

  @Benchmark
  def stm = ductSTM ! true

  @Benchmark
  def sync = ductSynchronized ! true
}
