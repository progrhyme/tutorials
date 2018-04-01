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

  def lift[A, B](f: A => B): Option[A] => Option[B] = _ map f

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

  test("flatMap") {
    val toDepartment = (employee: Employee) => Some(employee.department)
    assert(lookupByName("Joe").flatMap(toDepartment) === Some("X"))
    assert(lookupByName("Mr.X").flatMap(toDepartment) === None)
  }

  test("lift") {
    val abs0: Option[Double] => Option[Double] = lift(math.abs)
    assert(abs0(Some(-1.0)) === Some(1.0))
  }

  test("map2") {
    assert(Option.map2(None, None)((x: Int, y: Int) => x + y) === None)
    assert(Option.map2(None, Some(4))((x: Int, y: Int) => x + y) === None)
    assert(Option.map2(Some(2), Some(4))((x: Int, y: Int) => x + y) === Some(6))
  }

  test("traverse") {
    assert(Option.traverse(List("3", "-5", "0"))(stringToInt) === Some(List(3, -5, 0)))
    assert(Option.traverse(List("3", "-5", "0", "03"))(stringToInt) === None)
  }
}
