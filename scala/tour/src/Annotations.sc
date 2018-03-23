object DeprecationDemo extends App {
  @deprecated
  def hello = "hola"

  hello
}

/* Annotations that ensure correctness of encodings */
import scala.annotation.tailrec

def factorial(x: Int): Int = {

  @tailrec
  def factorialHelper(x: Int, accumulator: Int): Int = {
    if (x == 1) accumulator else factorialHelper(x - 1, accumulator * x)
  }
  factorialHelper(x, 1)
}

/**
  * Failing example
def factorial2(x: Int): Int = {
  @tailrec
  def factorialHelper(x: Int): Int = {
    if (x == 1) 1 else x * factorialHelper(x - 1)
    //Error:(22, 27) could not optimize @tailrec annotated method factorialHelper: it contains a recursive call not in tail position
  }
  factorialHelper(x)
}
*/

/* Annotations affecting code generation */
// Java Annotations
