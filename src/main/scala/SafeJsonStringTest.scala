package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class SafeJsonStringTest {

  object strings {
    val short = "Waiting"
    val medium = "Please be nice in the chat!"
    val long = """Free online Chess server. Play Chess now in a clean interface. No registration, no ads, no plugin required. Play Chess with the computer, friends or random opponents."""
    val arabic = """قد يكون خصمك قد ترك المباراة. يمكنك المطالبة بالنصر، أو التعادل، أو إنتظر."""
  }

  object impls {
    /*
     * Benchmark                       Mode  Cnt      Score      Error  Units
     * SafeJsonStringTest.base_arabic  avgt   10  40841.062 ± 2646.024  ns/op
     * SafeJsonStringTest.base_long    avgt   10   4006.184 ±  153.502  ns/op
     * SafeJsonStringTest.base_medium  avgt   10    812.464 ±   51.683  ns/op
     * SafeJsonStringTest.base_short   avgt   10    354.905 ±   49.701  ns/op
     */
    def base(str: String): String = {
      val escaped = str.flatMap { c =>
        val code = c.toInt
        if (c != '<' && c != '>' && c != '&' && c != '"' && c != '\'' && /* html */
          c != '\\' && /* remaining js */
          c != '`' && c != '/' && /* extra care */
          32 <= code && code <= 126 /* printable ascii */ ) Some(c) else {
          def hexCode = code.toHexString.reverse.padTo(4, '0').reverse
          '\\' +: s"u${hexCode.toUpperCase}"
        }
      }
      s""""${escaped}""""
    }
    // def opt1(s: String): String = {
    //   val sb = new StringBuilder(s.size)
    //   var i = 0
    //   while (i < s.length) {
    //     val code = c.toInt
    //     if (c != '<' && c != '>' && c != '&' && c != '"' && c != '\'' && /* html */
    //       c != '\\' && /* remaining js */
    //       c != '`' && c != '/' && /* extra care */
    //       32 <= code && code <= 126 /* printable ascii */ ) sb.append(c)
    //     else {
    //       def hexCode = code.toHexString.reverse.padTo(4, '0').reverse
    //       ('\\' +: s"u${hexCode.toUpperCase}") foreach sb.append
    //     }
    //     i += 1
    //   }
    //   sb.toString
    // }
  }

  @Benchmark
  def base_short = impls.base(strings.short)

  @Benchmark
  def base_medium = impls.base(strings.medium)

  @Benchmark
  def base_long = impls.base(strings.long)

  @Benchmark
  def base_arabic = impls.base(strings.arabic)
}
