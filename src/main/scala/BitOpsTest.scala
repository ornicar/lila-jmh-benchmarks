package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit

import org.lila.clockencoder.{BitReader,BitWriter}

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class BitOpsTest extends EncodingTestData {

  @Benchmark
  def testRead = {
    val r = new BitReader(encoded)
    Range(0, 50).map(_ => r.readBits(4))
  }
}
