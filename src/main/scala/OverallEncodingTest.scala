package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit

import org.lila.clockencoder.Encoder

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class OverallEncodingTest extends EncodingTestData {

  @Benchmark
  def testEncode = Encoder.encode(centis, startTime)

  @Benchmark
  def testDecode = Encoder.decode(encoded, moves, startTime)
}
