import fpinscala.streamingio.SimpleStreamTransducers.Process._

val p = liftOne((x: Int) => x * 2)

val xs = p(Stream(1, 2, 3)).toList

val units = Stream.continually(())

val ones = lift((_:Unit) => 1)(units)

val even = filter((x: Int) => x % 2 == 0)

val evens = even(Stream(1,2,3,4)).toList

val s = sum(Stream(1.0, 2.0, 3.0, 4.0)).toList
