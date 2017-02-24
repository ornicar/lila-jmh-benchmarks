package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import scala.concurrent.duration._
import scala.concurrent.duration.FiniteDuration
import java.util.concurrent.TimeUnit

import scala.collection.breakOut

case class Centis(cs: Int) extends AnyVal


@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class DurationConvertTest {
  implicit final class LilaPimpedFiniteDuration(self: FiniteDuration) {
    def toHundredths: Long = self.toMillis / 10
  }

  val data = Range(0, 30).map(_.millis).toVector
  val centiData = Range(0, 30).map(Centis).toVector

  val intCentiData = Range(0, 30).toVector




  @Benchmark
  def intToArray: Array[Int] = intCentiData.toArray

  @Benchmark
  def centiBreakout: Array[Int] = centiData.map(_.cs)(breakOut)

  @Benchmark
  def testToMillis = data.map(_.toMillis.toInt).toArray

  @Benchmark
  def testToHundredths = data.map(_.toHundredths.toInt).toArray
}
