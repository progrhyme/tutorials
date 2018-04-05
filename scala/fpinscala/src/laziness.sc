import fpinscala.laziness._

val stream = Stream(1,2,3)
val part = stream.take(2)
part.toList
