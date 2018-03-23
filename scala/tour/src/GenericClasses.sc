/* Defining a generic class */
class Stack[A] {
  private var elements: List[A] = Nil
  def push(x: A) { elements = x :: elements }
  def peek: A = elements.head
  def pop(): A = {
    val currentTop = peek
    elements = elements.tail
    currentTop
  }
}

/* Usage */
val stack = new Stack[Int]
stack.push(1)
stack.push(2)
println(stack.pop)
println(stack.pop)

class Fruit
class Apple extends Fruit
class Banana extends Fruit

val basket = new Stack[Fruit]
val apple = new Apple
val banana = new Banana

basket.push(apple)
basket.push(banana)
