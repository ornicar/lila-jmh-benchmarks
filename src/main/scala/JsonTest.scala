package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit

import play.api.libs.json._

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class JsonTests {

  val moveJson = Json.parse("""{"v":109,"t":"move","d":{"uci":"f2e3","san":"Ke3","fen":"8/5k2/8/p1pP2p1/P1P1p1P1/4Kp2/8/8","ply":109,"dests":{"f3":"f2","f7":"f8f6e7g7e8g8g6"},"clock":{"white":11.37,"black":12.74,"lag":4}}}""")
  val pongJson = Json.parse("""{"t":"n"}""")

  @Benchmark
  def stringifyMove = Json stringify moveJson

  @Benchmark
  def stringifyPong = Json stringify pongJson
}
