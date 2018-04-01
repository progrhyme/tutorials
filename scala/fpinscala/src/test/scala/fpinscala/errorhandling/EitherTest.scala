package fpinscala.errorhandling

import org.scalatest.FunSuite

class EitherTest extends FunSuite {
  def stringToInt(str: String): Either[String, Int] = str match {
    case s if s.toInt.toString() == s => Right(s.toInt)
    case _ => Left("Can't convert into Int!")
  }

  test("orElse") {
    assert(stringToInt("3").orElse(Right(-1)) === Right(3))
    assert(stringToInt("-5").orElse(Right(-1)) === Right(-5))
    assert(stringToInt("0").orElse(Right(-1)) === Right(0))
    assert(stringToInt("03").orElse(Right(-1)) === Right(-1))
    assert(stringToInt("000").orElse(Right(-1)) === Right(-1))
  }
}
