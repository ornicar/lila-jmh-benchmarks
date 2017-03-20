package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit

object implicitClasses {

  implicit final class ImplicitStandard[A](val oa: Option[A]) { def bar = oa.isDefined }
  implicit final class ImplicitAnyVal[A](val oa: Option[A]) extends AnyVal { def bar = oa.isDefined }
  @inline implicit final class ImplicitInlineBothAnyVal[A](val oa: Option[A]) extends AnyVal { @inline def bar = oa.isDefined }
  implicit final class ImplicitInlineFunAnyVal[A](val oa: Option[A]) extends AnyVal { @inline def bar = oa.isDefined }
  @inline implicit final class ImplicitInlineClassAnyVal[A](val oa: Option[A]) extends AnyVal { def bar = oa.isDefined }

}

object implicitFunctions {

  final class ImplicitStandard[A](val oa: Option[A]) { def bar = oa.isDefined }
  final class ImplicitAnyVal[A](val oa: Option[A]) extends AnyVal { def bar = oa.isDefined }
  final class ImplicitInlineAnyVal[A](val oa: Option[A]) extends AnyVal { @inline def bar = oa.isDefined }

  implicit def toStandard[A](oa: Option[A]) = new ImplicitStandard(oa)
  implicit def toAnyVal[A](oa: Option[A]) = new ImplicitAnyVal(oa)
  @inline implicit def toInlineAnyVal[A](oa: Option[A]) = new ImplicitInlineAnyVal(oa)
}

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class ImplicitClassTest {


  val option = Option(42)

  @Benchmark
  def testClassStandard = {
    import implicitClasses.ImplicitStandard
    option.bar
  }

  @Benchmark
  def testClassAnyVal = {
    import implicitClasses.ImplicitAnyVal
    option.bar
  }

  @Benchmark
  def testClassInlineBothAnyVal = {
    import implicitClasses.ImplicitInlineBothAnyVal
    option.bar
  }

  @Benchmark
  def testClassImplicitInlineFunAnyVal = {
    import implicitClasses.ImplicitInlineFunAnyVal
    option.bar
  }

  @Benchmark
  def testClassImplicitInlineClassAnyVal = {
    import implicitClasses.ImplicitInlineClassAnyVal
    option.bar
  }

  @Benchmark
  def testFunctionStandard = {
    import implicitFunctions.toStandard
    option.bar
  }

  @Benchmark
  def testFunctionAnyVal = {
    import implicitFunctions.toAnyVal
    option.bar
  }

  @Benchmark
  def testFunctionInlineAnyVal = {
    import implicitFunctions.toInlineAnyVal
    option.bar
  }

  @Benchmark
  def baseline = option.isDefined
}
