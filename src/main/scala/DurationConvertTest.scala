package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import scala.concurrent.duration._
import scala.concurrent.duration.FiniteDuration
import java.util.concurrent.TimeUnit

import scala.collection.breakOut

case class Centis(cs: Int) extends AnyVal

object implicits {

  implicit class LilaPimpedFiniteDuration(val self: FiniteDuration) extends AnyVal {
    def toHundredths: Long = self.toMillis / 10
  }
}

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class DurationConvertTest {

  import implicits._

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
