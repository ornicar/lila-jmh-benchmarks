package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit

object implicitClasses {

  implicit final class ImplicitStandard[A](val i: Int) { def bar = i + 2 }
  implicit final class ImplicitAnyVal[A](val i: Int) extends AnyVal { def bar = i + 2 }
  @inline implicit final class ImplicitInlineBothAnyVal[A](val i: Int) extends AnyVal { @inline def bar = i + 2 }
  implicit final class ImplicitInlineFunAnyVal[A](val i: Int) extends AnyVal { @inline def bar = i + 2 }
  @inline implicit final class ImplicitInlineClassAnyVal[A](val i: Int) extends AnyVal { def bar = i + 2 }

}

object implicitFunctions {

  final class ImplicitStandard[A](val i: Int) { def bar = i + 2 }
  final class ImplicitAnyVal[A](val i: Int) extends AnyVal { def bar = i + 2 }
  final class ImplicitInlineAnyVal[A](val i: Int) extends AnyVal { @inline def bar = i + 2 }

  implicit def toStandard[A](i: Int) = new ImplicitStandard(i)
  implicit def toAnyVal[A](i: Int) = new ImplicitAnyVal(i)
  @inline implicit def toInlineAnyVal[A](i: Int) = new ImplicitInlineAnyVal(i)
}

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class ImplicitClassTest {


  val option: Int = 42

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
  def baseline = option + 2
}
