package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit
import scala.util.matching.Regex

final class ornicarRegexWrapper(private val r: Regex) extends AnyVal {

  def find(s: String): Boolean =
    r.pattern.matcher(s).find

  def matches(s: String): Boolean =
    r.pattern.matcher(s).matches
}

trait RegexI {
  @inline implicit final def toOrnicarRegex(r: Regex) = new ornicarRegexWrapper(r)
}

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.MICROSECONDS)
class RegexTests extends RegexI {
  val unanchored = """\w+\d""".r
  val unanchoredPoss = """\w++\d""".r
  val anchoredPoss = """^\w++\d$""".r
  val anchored = """^\w+\d$""".r

  val l100NoMatch = "abcde" * 20
  val l100 = l100NoMatch + "0"
  val l1k = "abcde" * 200 + "0"


  val anchoredGroup = """^.*(\w).*$""".r
  val unanchoredGroup = """.*(\w).*""".r
  val rawGroup = """(\w)""".r
  val rawUnanchoredGroup = """(\w)""".r.unanchored

  val a = "a"
  val aPad = ("!" * 100) + "a" + ("!" * 100)
  val noA = "!" * 200


  @inline private def regM(r: Regex, s: String) = r.pattern.matcher(s).matches
  @inline private def regF(r: Regex, s: String) = r.pattern.matcher(s).find

  @Benchmark
  def sMatchUnanchored = regM(unanchored, l100)

  @Benchmark
  def sMatchUnanchoredPoss = regM(unanchoredPoss, l100)

  @Benchmark
  def sMatchAnchored = regM(anchored, l100)

  @Benchmark
  def sMatchAnchoredPoss = regM(anchoredPoss, l100)

  @Benchmark
  def lMatchUnanchored = regM(unanchored, l1k)

  @Benchmark
  def lMatchUnanchoredPoss = regM(unanchoredPoss, l1k)

  @Benchmark
  def lMatchAnchored = regM(anchored, l1k)

  @Benchmark
  def lMatchAnchoredPoss = regM(anchoredPoss, l1k)

  @Benchmark
  def sNoMatchUnanchored = regM(unanchored, l100NoMatch)

  @Benchmark
  def sNoMatchUnanchoredPoss = regM(unanchoredPoss, l100NoMatch)

  @Benchmark
  def sNoMatchAnchored = regM(anchored, l100NoMatch)

  @Benchmark
  def sNoMatchAnchoredPoss = regM(anchoredPoss, l100NoMatch)

  @Benchmark
  def cGroupAnchored = regM(anchoredGroup, a)

  @Benchmark
  def cGroupUnanchored = regM(unanchoredGroup, a)

  @Benchmark
  def cGroupRawFind = regF(rawGroup, a)

  @Benchmark
  def cGroupRawFindImplicit = rawGroup.find(a)

  @Benchmark
  def cGroupUnanchoredClassFind = regF(rawUnanchoredGroup, a)

  @Benchmark
  def cGroupUnanchoredClassFindImplicit = rawUnanchoredGroup.find(a)

  @Benchmark
  def pGroupAnchored = regM(anchoredGroup, aPad)

  @Benchmark
  def pGroupUnanchored = regM(unanchoredGroup, aPad)

  @Benchmark
  def pGroupRawFind = regF(rawGroup, aPad)

  @Benchmark
  def pGroupUnanchoredClassFind = regF(rawUnanchoredGroup, aPad)

  @Benchmark
  def noAGroupAnchored = regM(anchoredGroup, noA)

  @Benchmark
  def noAGroupUnanchored = regM(unanchoredGroup, noA)

  @Benchmark
  def noAGroupRawFind = regF(rawGroup, noA)

  @Benchmark
  def noAGroupUnanchoredClassFind = regF(rawUnanchoredGroup, noA)

  @Benchmark
  def pMatcher = aPad match {
    case unanchoredGroup(x) => x
  }

  @Benchmark
  def pMatcherUnanchored = aPad match {
    case rawUnanchoredGroup(x) => x
  }

  @Benchmark
  def pMatcherUnanchoredIgnoreVars = aPad match {
    case rawUnanchoredGroup(_*) => "y"
  }
}
