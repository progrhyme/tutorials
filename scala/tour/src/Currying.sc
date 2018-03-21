import scala.concurrent.ExecutionContext

val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
val res = numbers.foldLeft(0)((m, n) => m + n)
print(res)

numbers.foldLeft(1)((m, n) => m * n)

// Single Functional Parameter
//numbers.foldLeft(0, {(m: Int, n: Int) => m + n})

numbers.foldLeft(0)(_ + _)


val numberFunc = numbers.foldLeft(List[Int]())_
val squares = numberFunc((xs, x) => xs:+ x*x)
// same as below:
//   numbers.foldLeft(List[Int]())((xs, x) => xs:+ x*x)
print(squares.toString())

val cubes = numberFunc((xs, x) => xs:+ x*x*x)
print(cubes.toString())

val s = Seq(1, 2, 3)
s :+ 4
s.+:(0)

// Implicit Parameters
def execute(arg: Int)(implicit ec: ExecutionContext): Unit = {}
