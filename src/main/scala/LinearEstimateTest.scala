package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit

import org.lila.clockencoder.{LinearEstimator,WeightedLinearEstimator}

import scala.util.Random

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class LinearEstimateTest {
  val r = new Random()
  val testData = Range(3000, 0, -100).map(_ + (r.nextGaussian * 100) toInt) toArray

  @Benchmark
  def testEncode = LinearEstimator.process(testData, true)

  @Benchmark
  def testWeightedEncode = WeightedLinearEstimator.process(testData, true)
}
