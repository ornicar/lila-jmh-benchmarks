package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class StringTests {

  @Benchmark
  def stringContains = "foobar".contains("a")

  @Benchmark
  def charContains = "foobar".contains('a')

  @Benchmark
  def charIndexOf = "foobar".indexOf('a') >= 0
}
