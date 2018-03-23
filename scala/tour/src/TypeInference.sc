/* Omitting the type */
val businessName = "Montreux Jazz Café"

def squareOf(x: Int) = x * x

//def fac(n: Int) = if (n == 0) 1 else n * fac(n - 1)
//Error:(6, 43) recursive method fac needs result type
def fac(n: Int): Int = if (n == 0) 1 else n * fac(n - 1)

case class MyPair[A, B](x: A, y: B)
val p = MyPair(1, "scala") // type: MyPair[Int, String]

def id[T](x: T) = x
val q = id(1)

/* Parameters */
Seq(1, 3, 4).map(x => x * 2)

/* When not to rely on type inference */
//var obj = null // too specific. Infered as `Null`
var obj: AnyRef = null

obj = new AnyRef