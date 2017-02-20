package org.openjdk.jmh.samples

import org.lila.clockencoder._
import scala.util.Random

trait EncodingTestData {
  private val r = new Random(1)
  val startTime = 30000
  val centis = Range(29100, 0, -1000).map(_ + (r.nextGaussian * 500) toInt) toArray
  val moves = centis.size - 1
  val trunced = LowBitTruncator.lossyEncode(centis, new IntArrayList)
  val encodedRounds = trunced.clone
  LinearEstimator.encode(encodedRounds, startTime)
  val encoded = Encoder.encode(centis, startTime)
}