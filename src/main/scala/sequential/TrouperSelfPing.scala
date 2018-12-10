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
class TrouperSelfPing extends Zero.Syntax {

  /*
   * [info] Benchmark                     Mode  Cnt         Score   Error  Units
   * [info] Sequential.pingAtomicTrouper  avgt       40677813.289          ns/op
   * [info] Sequential.pingTrouper        avgt       52379683.743          ns/op
   */

  object Ping
  object Wut

  object make {
    def selfPingSTMTrouper(messages: Int, latch: CountDownLatch) = new STMTrouper {
      var left = messages
      val process: STMTrouper.Receive = {
        case Ping =>
          if (left == 0) latch.countDown()
          else {
            // this ! Wut
            // this ! Wut
            this ! Ping
            left -= 1
          }
        case Wut =>
      }
    }
    def selfPingAtomicTrouper(messages: Int, latch: CountDownLatch) = new AtomicTrouper {
      var left = messages
      val process: AtomicTrouper.Receive = {
        case Ping =>
          if (left == 0) latch.countDown()
          else {
            // this ! Wut
            // this ! Wut
            this ! Ping
            left -= 1
          }
        case Wut =>
      }
    }
  }

  @Benchmark
  def selfPingSTMTrouper = {
    val messages = 100000
    val startNanoTime = System.nanoTime()
    val latch = new CountDownLatch(1)
    make.selfPingSTMTrouper(messages, latch) ! Ping
    latch.await(1, TimeUnit.SECONDS)
    val durationMicros = (System.nanoTime() - startNanoTime) / 1000
    println(f"$messages pings took ${durationMicros / 1000} ms, " +
      f"${messages.toDouble / durationMicros}%,.2f M msg/s")
  }

  @Benchmark
  def selfPingAtomicTrouper = {
    val messages = 100000
    val startNanoTime = System.nanoTime()
    val latch = new CountDownLatch(1)
    make.selfPingAtomicTrouper(messages, latch) ! Ping
    latch.await(1, TimeUnit.SECONDS)
    val durationMicros = (System.nanoTime() - startNanoTime) / 1000
    println(f"$messages pings took ${durationMicros / 1000} ms, " +
      f"${messages.toDouble / durationMicros}%,.2f M msg/s")
  }

  // @Benchmark
  // def stmNoFlag = ductSTMNoFlag ! true

  // @Benchmark
  // def sync = ductSynchronized ! true
}
