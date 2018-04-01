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
