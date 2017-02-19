package org.openjdk.jmh.samples

import org.lila.clockencoder._
import scala.util.Random

trait EncodingTestData {
  private val r = new Random(1)
  val centis = Range(30000, 0, -1000).map(_ + (r.nextGaussian * 500) toInt) toArray
  val moves = centis.size
  val trunc = LowBitTruncator.lossyEncode(centis)
  val encodedRounds = LinearEstimator.process(trunc.trunced, true)
  val encoded = Encoder.encode(centis)
}