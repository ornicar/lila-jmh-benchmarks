package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class NullTest {

  class Foo

  val a: Foo = null
  val b: Foo = new Foo

  def isNotNull[X](x: X) = x != null

  @inline def isNotNullInline[X](x: X) = x != null

  @Benchmark
  def testNullWithOption = Option(a).isDefined

  @Benchmark
  def testDefinedWithOption = Option(b).isDefined

  @Benchmark
  def testNullWithFunction = isNotNull(a)

  @Benchmark
  def testDefinedWithFunction = isNotNull(b)

  @Benchmark
  def testNullWithFunctionInline = isNotNullInline(a)

  @Benchmark
  def testDefinedWithFunctionInline = isNotNullInline(b)
}
