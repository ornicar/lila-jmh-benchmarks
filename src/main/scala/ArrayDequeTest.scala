package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit
import java.util.ArrayDeque
import scala.collection.JavaConverters._

case class SocketVersion(value: Int) extends AnyVal with Ordered[SocketVersion] {
  def compare(other: SocketVersion) = value compare other.value
  def inc = SocketVersion(value + 1)
}

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class ArrayDequeTest {

  private[this] final val deque = new ArrayDeque[SocketVersion]()
  for (i <- 1 to 50) deque.add(SocketVersion(i))

  private[this] final val list = deque.asScala.toList.reverse

  private[this] final val v = SocketVersion(40)

  @Benchmark
  def testDrop = deque.asScala.dropWhile(_ <= v).toList

  @Benchmark
  def testReverse = {
    var fe: List[SocketVersion] = Nil
    for (e <- deque.descendingIterator.asScala.takeWhile(_ > v))
      fe = e :: fe
    fe
  }

  @Benchmark
  def testSlice = {
    var fe: List[SocketVersion] = Nil
    val it = deque.descendingIterator
    var cnt = 10
    while (it.hasNext && cnt > 0) {
      fe = it.next :: fe
      cnt -= 1
    }
  }
  
  @Benchmark
  def testListLegacy = list.takeWhile(_ > v).reverse
}
