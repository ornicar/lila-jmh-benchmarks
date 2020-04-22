package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.lang.{ StringBuilder => jStringBuilder }
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

  // newlines to breaks with at most 2 consecutive breaks using loop
  def nl2brLimitedLoop(s: String): String = {
    val sb = new jStringBuilder(s.length)
    var counter = 0
    for (char <- s) {
      if (char == '\n') {
        counter += 1
        if (counter < 3) {
          sb.append("<br />")
        }
      } else if (char != '\r') {
        counter = 0
        sb.append(char)
        }
    }
    sb.toString
  }

  // newlines to breaks with at most 2 consecutive breaks using regex
  def nl2brLimitedRegex(s: String): String =
    s.replaceAll("[\r\n]{3,}", "\n\n")
      .replaceAll("\r\n|\n", "<br />") 

  // newlines to breaks with no limit to consecutive breaks
  def nl2brUnlimited(s: String): String = {
      var i = s.indexOf('\n')
      if (i < 0) s
      else {
        val sb      = new jStringBuilder(s.length + 30)
        var copyIdx = 0
        do {
          if (i > copyIdx) {
            // copyIdx >= 0, so i - 1 >= 0
            sb.append(s, copyIdx, if (s.charAt(i - 1) == '\r') i - 1 else i)
          }
          sb.append("<br />")
          copyIdx = i + 1
          i = s.indexOf('\n', copyIdx)
        } while (i >= 0)

        sb.append(s, copyIdx, s.length)
        sb.toString
      }
    }

  val badChars = "[<>&\"']".r.pattern
  def escapeOptimistRegex(s: String): String = if (badChars.matcher(s).find) escape(s) else s

  val shortAscii = "Outside the board"
  val shortUnicode = "Ожидание соперниа"

  val longAscii = "Free online Chess server. Play Chess now in a clean interface. No registration, no ads, no plugin required. Play Chess with the computer, friends or random opponents."
  val longUnicode = "Бесплатные онлайн-шахматы. Играйте в шахматы прямо сейчас в простом интерфейсе без рекламы. Не требует регистрации и скачивания программы. Играйте в шахматы с компьи."

  val shortNewLines = "Hello\n\n\nWorld"
  val longNewLines = "Hello\n\n\nWorld\n\n\nHere\n\n\nI\n\n\nCome\n\n\nAgain.\n\n\nWanna\n\n\nPlay\n\n\nChess?"

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

  @Benchmark
  def testShortNewLinesLimitedRegex = nl2brLimitedRegex(shortNewLines)

  @Benchmark
  def testShortNewLinesLimitedLoop = nl2brLimitedLoop(shortNewLines)

  @Benchmark
  def testShortNewLinesUnlimited = nl2brUnlimited(shortNewLines)

  @Benchmark
  def testLongNewLinesLimitedRegex = nl2brLimitedRegex(longNewLines)

  @Benchmark
  def testLongNewLinesLimitedKLoop = nl2brLimitedLoop(longNewLines)

  @Benchmark
  def testLongNewLinesUnlimited = nl2brUnlimited(longNewLines)
}

