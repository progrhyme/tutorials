import scala.annotation.tailrec

def curry[A, B, C](f: (A, B) => C): A => (B => C) =
  (a: A) => (b: B) => f(a, b)

val addCurried = curry((x: Int, y: Int) => x + y)
val partAdd = addCurried(5)

partAdd(4)

def uncurry[A, B, C](f: A => B => C): (A, B) => C =
  (a: A, b: B) => f(a)(b)

val add = uncurry(addCurried)
add(10, 20)

def compose[A, B, C](f: B => C, g: A => B): A => C = (a: A) => f(g(a))

def fib(n: Int): Int = {
  def go(n: Int, acc1: Int, acc2: Int): Int = {
    n match {
      case 1 => acc1
      case 2 => acc2
      case _ => go(n-1, acc2, acc1 + acc2)
    }
  }

  go(n, 0, 1)
}

fib(5)
fib(10)

def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
  def go(as: Array[A], n: Int): Boolean = {
    if (n >= as.length - 1) true
    else if (ordered(as(n), as(n+1))) go(as, n + 1)
    else false
  }
  go(as, 0)
}
