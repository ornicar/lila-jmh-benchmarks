package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit

trait Zero[F] {
  def zero: F
}

object Zero {
  def instance[A](z: A): Zero[A] = new Zero[A] {
    def zero = z
  }

  trait Syntax {
    def zero[F](implicit F: Zero[F]): F = F.zero
  }

  implicit val iNormalZ = Zero.instance(1f)
  implicit final val iFinalZ = Zero.instance(1)
}

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class FinalValsTest extends Zero.Syntax {

  import Zero._

  @Benchmark
  def iNormal = zero[Float]

  @Benchmark
  def iFinal = zero[Int]
}
