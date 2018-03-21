def factorial(x: Int): Int = {
  def fact(x: Int, accumulator: Int): Int = {
    if (x <= 1) accumulator
    else fact(x - 1, x * accumulator)
  }
  fact(x, 1)
}

println("Factorial of 2: " + factorial(2))
println("Factorial of 3: " + factorial(3))

def fact2(x: Int): Int = {
  if (x > 1) x * fact2(x - 1)
  else 1
}

fact2(3)
fact2(5)

/* Nested Function */
val f = (x: Int) => {
  val g = () => x * x
  g()
}

f(5)