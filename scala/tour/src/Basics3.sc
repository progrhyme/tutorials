/* Objects */
object IdFactory {
  private var counter = 0
  def create(): Int = {
    counter += 1
    counter
  }
}

val newId: Int = IdFactory.create()
println(newId) // 1
val newerId: Int = IdFactory.create()
println(newerId) // 2

/* Traits */
trait Greeter {
  def greet(name: String): Unit
}

trait Greeter2 {
  def greet(name: String): Unit =
    println("Hello, " + name + "!")
}

class DefaultGreeter extends Greeter2

class CustomizableGreeter(prefix: String, postfix: String) extends Greeter2 {
  override def greet(name: String): Unit = {
    println(prefix + name + postfix)
  }
}

val greeter = new DefaultGreeter()
greeter.greet("Scala developer")

val customGreeter = new CustomizableGreeter("How are you, ", "?")
customGreeter.greet("Scala developer")

/* Main Method */
object Main {
  def main(args: Array[String]): Unit =
    println("Hello, Scala developer!")
}