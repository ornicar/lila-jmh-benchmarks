package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._
import annotation.tailrec

import java.util.concurrent.TimeUnit

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class InterleaveTest {
  @tailrec
  final def i1[A](base: Vector[A], a: List[A], b: List[A]): Vector[A] = a match {
    case elt :: aTail => i1(base :+ elt, b, aTail)
    case _ => base ++ b
  }  

  @tailrec
  final def i2[T](base: Vector[T], l1: List[T], l2: List[T]): Vector[T] =
    (l1, l2) match {
      case (h1 :: t1, h2 :: t2) => i2(base :+ h1 :+ h2, t1, t2)
      case (l1, l2)            => base ++ l1 ++ l2
  }

  @tailrec
  final def iVec1[A](acc: Vector[A], a: Vector[A], b: Vector[A]): Vector[A] = (a, b) match {
    case (a1 +: as, b1 +: bs) => iVec1(acc :+ a1 :+ b1, as, bs)
    case (x, y) => acc ++ x ++ y
  }


  final def i3[A](a: Seq[A], b: Seq[A]): Vector[A] = {
    val iterA = a.iterator
    val iterB = b.iterator
    val builder = Vector.newBuilder[A]
    while (iterA.hasNext && iterB.hasNext) {
      builder += iterA.next += iterB.next
    }
    builder ++= iterA ++= iterB

    builder.result
  }

  val l100 = (1 to 100).toList
  val v100 = l100.toVector


  @Benchmark
  def interleaveL1 = i1(Vector.empty, l100, l100)

  @Benchmark
  def interleaveL2 = i2(Vector.empty, l100, l100)

  @Benchmark
  def interleaveL3 = i3(l100, l100)

  @Benchmark
  def interleaveV1 = iVec1(Vector.empty, v100, v100)

  @Benchmark
  def interleaveV3 = i3(v100, v100)
}
