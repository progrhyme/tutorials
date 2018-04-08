import fpinscala.laziness._

val stream = Stream(1,2,3)
val part = stream.take(2)
part.toList

Stream(1,2,3,4,5,6).takeWhile(_ % 2 == 1).toList

Stream(1,2,3,4,5,6).exists(_ == 5)

val ones: Stream[Int] = Stream.cons(1, ones)
ones.take(5).toList
ones.exists(_ % 2 != 0)
ones.map(_ + 1).exists(_ % 2 == 0)
ones.takeWhile(_ == 1).take(3).toList
ones.forAll(_ != 1)
ones.headOption

Stream.fibsViaUnfold.take(10).toList

Stream(1,2,3).zipWith(Stream("a", "b", "c"))((n, s) => s * n).toList

def zipper(n: Option[Int], s: Option[String]): String =
  (n, s) match {
    case (Some(_), Some(_)) => s.get * n.get
    case _ => ""
  }

Stream(1,2,3,4).zipWithAll(Stream("a", "b", "c"))((n, s) => {
  (n, s) match {
    case (Some(_), Some(_)) => s.get * n.get
    case _ => "<default>"
  }
}).toList

Stream.from(1).startsWith(Stream(1,2,3))
Stream.from(1).startsWith(Empty)
