package sequential

import org.openjdk.jmh.annotations._
import org.openjdk.jmh.samples._

import java.util.concurrent.{ CountDownLatch, TimeUnit }

import akka.actor._
import scala.collection.immutable.Queue
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.stm._

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class TrouperPingPong extends Zero.Syntax {

  /*
   * [info] Benchmark                              Mode  Cnt         Score   Error  Units
   * [info] TrouperPingPong.pingPongAtomicTrouper  avgt       61008170.677          ns/op
   * [info] TrouperPingPong.pingPongSTMTrouper     avgt       81202068.887          ns/op
   */

  case class STMPing(from: STMTrouper)
  case class AtomicPing(from: AtomicTrouper)
  object Wut

  object make {
    def pingPongSTMTrouper(messages: Int, latch: CountDownLatch) = new STMTrouper {
      var left = messages
      val process: STMTrouper.Receive = {
        case STMPing(from) =>
          if (left == 0) latch.countDown()
          else {
            left -= 1
            from ! STMPing(this)
          }
        case Wut =>
      }
    }
    def pingPongAtomicTrouper(messages: Int, latch: CountDownLatch) = new AtomicTrouper {
      var left = messages
      val process: AtomicTrouper.Receive = {
        case AtomicPing(from) =>
          if (left == 0) latch.countDown()
          else {
            left -= 1
            from ! AtomicPing(this)
          }
        case Wut =>
      }
    }
  }

  // @Benchmark
  // def pingPongSTMTrouper = {
  //   val messages = 100000
  //   val startNanoTime = System.nanoTime()
  //   val latch = new CountDownLatch(1)
  //   val ping = make.pingPongSTMTrouper(messages, latch)
  //   val pong = make.pingPongSTMTrouper(messages, latch)
  //   ping ! STMPing(pong)
  //   latch.await(1, TimeUnit.SECONDS)
  //   val durationMicros = (System.nanoTime() - startNanoTime) / 1000
  //   println(f"$messages pings took ${durationMicros / 1000} ms, " +
  //     f"${messages.toDouble / durationMicros}%,.2f M msg/s")
  // }

  @Benchmark
  def pingPongAtomicTrouper = {
    val messages = 100000
    val startNanoTime = System.nanoTime()
    val latch = new CountDownLatch(1)
    val ping = make.pingPongAtomicTrouper(messages, latch)
    val pong = make.pingPongAtomicTrouper(messages, latch)
    ping ! AtomicPing(pong)
    latch.await(1, TimeUnit.SECONDS)
    val durationMicros = (System.nanoTime() - startNanoTime) / 1000
    println(f"$messages pings took ${durationMicros / 1000} ms, " +
      f"${messages.toDouble / durationMicros}%,.2f M msg/s")
  }
}
