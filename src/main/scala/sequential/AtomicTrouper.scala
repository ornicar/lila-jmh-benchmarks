package sequential

import java.util.concurrent.atomic.AtomicReference
import java.util.function.UnaryOperator
import scala.collection.immutable.Queue
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ Future, Promise }

/*
 * Like Trouper but with AtomicReference instead of STM
 */
trait AtomicTrouper {

  import AtomicTrouper._

  // implement async behaviour here
  protected val process: Receive

  private[this] var alive = true

  def stop(): Unit = {
    alive = false
  }

  def !(msg: Any): Unit =
    if (alive && stateRef.getAndUpdate(
      new UnaryOperator[State] {
        override def apply(state: State): State = Some(state.fold(Queue.empty[Any])(_ enqueue msg))
      }
    ).isEmpty) run(msg)

  def ask[A](makeMsg: Promise[A] => Any): Future[A] = {
    val promise = Promise[A]
    this ! makeMsg(promise)
    promise.future
  }

  def queueSize = stateRef.get().fold(0)(_.size)

  /*
   * Idle: None
   * Busy: Some(Queue.empty)
   * Busy with backlog: Some(Queue.nonEmpty)
   */
  private[this] val stateRef: AtomicReference[State] = new AtomicReference(None)

  private[this] def run(msg: Any): Unit = Future {
    process.applyOrElse(msg, fallback)
  } onComplete postRun

  private[this] val postRun = (_: Any) =>
    stateRef.getAndUpdate(postRunUpdate) flatMap (_.headOption) foreach run

  private val fallback: Trouper.Receive = {
    case Shutdown => stop()
    case msg => println(s"unhandled msg: $msg")
  }

  lazy val uniqueId = Integer.toHexString(hashCode)
}

object AtomicTrouper {

  case object Shutdown

  type Receive = PartialFunction[Any, Unit]

  private type State = Option[Queue[Any]]

  private val postRunUpdate = new UnaryOperator[State] {
    override def apply(state: State): State =
      state flatMap { q =>
        if (q.isEmpty) None else Some(q.tail)
      }
  }
}
