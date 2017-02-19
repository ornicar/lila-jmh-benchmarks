package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit

import org.lila.clockencoder.Encoder

import scala.util.Random

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class OverallEncodingTest {
  val r = new Random()
  val testData = Range(30000, 0, -100).map(_ + (r.nextGaussian * 1000) toInt) toArray
  val moves = testData.size
  val encodedTestData = Encoder.encode(testData)

  @Benchmark
  def testEncode = Encoder.encode(testData)

  @Benchmark
  def testDecode = Encoder.decode(encodedTestData, moves)
}
