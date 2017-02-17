package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit

case class Without(value: Int)
case class Withit(value: Int) extends AnyVal

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class AnyValTest {

  @Benchmark
  def testWithout = Without(42)

  @Benchmark
  def testWithit = Withit(42)
}
