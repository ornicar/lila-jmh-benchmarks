package org.openjdk.jmh.samples

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit
import org.mindrot.BCrypt
import org.mindrot.orig.{BCrypt => BCryptOrig}

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.MILLISECONDS)
class BCryptTest {
  val salt = BCrypt.gensaltRaw
  val b64Salt = BCrypt.gensalt(12)

  @Benchmark
  def work10 = BCrypt.hashpwRaw("foo", 'a', 10, salt)

  @Benchmark
  def work11 = BCrypt.hashpwRaw("foo", 'a', 11, salt)

  @Benchmark
  def work12 = BCrypt.hashpwRaw("foo", 'a', 12, salt)

  @Benchmark
  def work12_b64 = BCrypt.hashpw("foo", b64Salt)

  @Benchmark
  def work12_b64_orig = BCryptOrig.hashpw("foo", b64Salt)
}
