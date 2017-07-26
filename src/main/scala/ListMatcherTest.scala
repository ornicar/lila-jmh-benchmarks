package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import scala.concurrent.duration._
import java.util.concurrent.TimeUnit

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class ListMatcherTest {

  val ls = (0 to 4) map { i => (1 to i).toList } toList

  @Benchmark
  def matchCons = ls collect {
    case x :: y :: _ => true
    case _ => false
  }

  @Benchmark
  def matchVars = ls collect {
    case List(x, y, _*) => true
    case _ => false
  }

  @Benchmark
  def sizeBase = ls map { _.size >= 2 }
}
