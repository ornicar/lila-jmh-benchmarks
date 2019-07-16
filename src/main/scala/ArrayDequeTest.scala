package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit
import java.util.ArrayDeque
import scala.collection.JavaConverters._

case class SocketVersion(value: Int) extends AnyVal with Ordered[SocketVersion] {
  def compare(other: SocketVersion) = value compare other.value
  def inc = SocketVersion(value + 1)
}

case class VersionedEvent(version: SocketVersion, date: Int) {}


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
  def testWhileReverse = {
    var fe: List[SocketVersion] = Nil
    var e = null.asInstanceOf[SocketVersion]
    val it = deque.descendingIterator
    while (it.hasNext && {
      e = it.next
      e > v
    }) fe = e :: fe
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

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class ArrayDequeAddTest {
  private[this] var deque = new ArrayDeque[VersionedEvent]()
  for (i <- 1 to 50) deque.add(VersionedEvent(SocketVersion(i), i))
  private[this] final val dequeClone = deque.clone()
  @Setup(Level.Invocation)
  def setUp() = {
    deque = dequeClone.clone()
  }

  private[this] final val list = deque.asScala.toList.reverse

  val newEvents = (51 to 55).map(i => VersionedEvent(SocketVersion(i), i)).toList

  @Benchmark
  def testAddEventsLegacy = {
    (slideEvents(list), newEvents.reverse)
  }


  private def slideEvents(history: List[VersionedEvent]) = {
    val expiration: Int = -1
    var nb = 0
    newEvents ::: history.takeWhile { e =>
      nb += 1
      nb <= 25 && e.date > expiration
    }
  }

  @Benchmark
  def testAddEventsDeque = {
    removeTail(25)
    pruneEvents(-1)
    val veBuff = List.newBuilder[VersionedEvent]
    newEvents.foreach { e =>
      veBuff += e
      deque.addLast(e)
    }
    (veBuff.result, deque)
  }

  private def removeTail(maxSize: Int) = {
    if (maxSize <= 0) deque.clear()
    else {
      var toRemove = deque.size() - maxSize
      while (toRemove > 0) {
        deque.pollFirst
        toRemove -= 1
      }
    }
  }

  private def pruneEvents(minDate: Int) = {
    while ({
      val e = deque.peekFirst
      (e ne null) && e.date < minDate
    }) deque.pollFirst
  }
}
