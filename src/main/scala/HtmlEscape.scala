package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class HtmlEscape {

  /* Results (i7 6700HQ)
[info] Benchmark                    Mode  Cnt     Score     Error  Units
[info] HtmlEscape.testLongAscii     avgt   10  3504.387 ± 198.163  ns/op
[info] HtmlEscape.testLongUnicode   avgt   10  3924.027 ± 102.305  ns/op
[info] HtmlEscape.testShortAscii    avgt   10   382.070 ±  18.223  ns/op
[info] HtmlEscape.testShortUnicode  avgt   10   429.636 ±  12.383  ns/op
*/

  def escape(s: String): String = {
    val sb = new StringBuilder
    var i = 0
    while (i < s.length) {
      sb.append {
        s.charAt(i) match {
          case '<' => "&lt;"
          case '>' => "&gt;"
          case '&' => "&amp;"
          case '"' => "&quot;"
          case '\'' => "&#39;"
          case c => c
        }
      }
      i += 1
    }
    sb.toString
  }

  def escapeOptimist(s: String): String = {
    var i = 0
    while (i < s.length) {
      val c = s.charAt(i)
      if (c == '<' || c == '>' || c == '&' || c == '"' || c == '\'') return escape(s)
      i += 1
    }
    s
  }

  val badChars = "[<>&\"']".r.pattern
  def escapeOptimistRegex(s: String): String = if (badChars.matcher(s).find) escape(s) else s

  val shortAscii = "Outside the board"
  val shortUnicode = "Ожидание соперниа"

  val longAscii = "Free online Chess server. Play Chess now in a clean interface. No registration, no ads, no plugin required. Play Chess with the computer, friends or random opponents."
  val longUnicode = "Бесплатные онлайн-шахматы. Играйте в шахматы прямо сейчас в простом интерфейсе без рекламы. Не требует регистрации и скачивания программы. Играйте в шахматы с компьи."

  @Benchmark
  def testShortAscii = escape(shortAscii)

  @Benchmark
  def testShortUnicode = escape(shortUnicode)

  @Benchmark
  def testLongAscii = escape(longAscii)

  @Benchmark
  def testLongUnicode = escape(longUnicode)

  @Benchmark
  def testLongUnicodeOptimist = escapeOptimist(shortUnicode)

  @Benchmark
  def testLongUnicodeOptimistRegex = escapeOptimistRegex(shortUnicode)
}

