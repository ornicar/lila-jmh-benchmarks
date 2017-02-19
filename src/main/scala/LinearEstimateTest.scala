package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit

import org.lila.clockencoder.{LinearEstimator,WeightedLinearEstimator}

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class LinearEstimateTest extends EncodingTestData {

  @Benchmark
  def testEncode = LinearEstimator.process(trunc.trunced, true)

  @Benchmark
  def testWeightedEncode = WeightedLinearEstimator.process(trunc.trunced, true)
}
