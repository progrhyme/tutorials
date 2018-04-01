package fpinscala.errorhandling

import org.scalatest.FunSuite

class OptionTest extends FunSuite {
  case class Employee(name: String, department: String)

  def lookupByName(name: String): Option[Employee] = name match {
    case "Joe" => Some(Employee(name, "X"))
    case "Mr.X" => None
    case s => Some(Employee(s, "some department"))
  }

  def stringToInt(str: String): Option[Int] = str match {
    case s if s.toInt.toString() == s => Some(s.toInt)
    case _ => None
  }

  test("lookupByName") {
    assert(lookupByName("Joe") === Some(Employee("Joe", "X")))
    assert(lookupByName("Mr.X") === None)
    assert(lookupByName("Bob") === Some(Employee("Bob", "some department")))
  }

  test("map") {
    assert(lookupByName("Joe").map(_.department) === Some("X"))
    assert(lookupByName("Mr.X").map(_.department) === None)
  }

  test("filter") {
    assert(lookupByName("Joe").filter(_.department == "X") === Some(Employee("Joe", "X")))
    assert(lookupByName("Joe").filter(_.department == "Y") === None)
    assert(lookupByName("Mr.X").filter(_.department == "X") === None)
  }

  test("getOrElse") {
    assert(stringToInt("3").getOrElse(-1) === 3)
    assert(stringToInt("-5").getOrElse(-1) === -5)
    assert(stringToInt("0").getOrElse(-1) === 0)
    assert(stringToInt("03").getOrElse(-1) === -1)
    assert(stringToInt("000").getOrElse(-1) === -1)
  }
}
