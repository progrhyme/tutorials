/* Defining a class */
class User

val user1 = new User

class Point(var x: Int, var y: Int) {
  def move(dx: Int, dy: Int): Unit = {
    x = x + dx
    y = y + dy
  }

  override def toString: String = s"($x, $y)"
}

val point1 = new Point(2, 3)
point1.x
println(point1)

/* Constructors */
class Ptr(var x: Int = 0, var y: Int = 0)

val origin = new Ptr
val ptr1 = new Ptr(1)
println(ptr1.x)

class Position(var x: Int = 0, var y: Int = 0)
val position2 = new Position(y=2)
println(position2.y)

/* Private Members and Getter/Setter Syntax */
class Pointer {
  private var _x = 0
  private var _y = 0
  private val bound = 100

  def x = _x
  def x_= (newValue: Int): Unit = {
    if (newValue < bound) _x = newValue else printWarning
  }

  def y = _y
  def y_= (newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning
  }

  private def printWarning = println("WARNING: Out of bounds")
}

val pointer1 = new Pointer
pointer1.x = 99
pointer1.y = 101

class Pos(val x: Int, val y: Int)
val pos = new Pos(1, 2)
//pos.x = 3 // Compilation Error! val is immutable

class Pos2(x: Int, y: Int) // private member values
val pos2 = new Pos2(1, 2)
//pos2.x // Compilation Error!