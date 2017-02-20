package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit

import org.lila.clockencoder.{LowBitTruncator, IntArrayList}

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class LowBitTruncTest extends EncodingTestData {

  @Benchmark
  def testEncode = LowBitTruncator.lossyEncode(centis, new IntArrayList)
}
