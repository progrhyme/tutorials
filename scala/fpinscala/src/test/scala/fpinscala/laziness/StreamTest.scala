package fpinscala.laziness

import org.scalatest.FunSuite

class StreamTest extends FunSuite {
  test("toList") {
    assert(Stream(1, 2, 3).toList === List(1, 2, 3))
  }
}
