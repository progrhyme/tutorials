package fpinscala.datastructures

import org.scalatest.FunSuite

class ListTest extends FunSuite {
  test("List.sum") {
    assert(List.sum(List(1, 2, 3)) === 6)
  }
}