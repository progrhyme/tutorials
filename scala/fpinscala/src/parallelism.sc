import java.util.concurrent.Executors

import fpinscala.parallelism._

val a = Par.lazyUnit(42 + 1)
val S = Executors.newFixedThreadPool(1)
//println(Par.equal(S)(a, Par.fork(a)))

val T = Executors.newFixedThreadPool(4)
val echoer = Actor[String](T) {
  msg => println(s"Got message: '$msg'")
}

echoer ! "hello"
echoer ! "goodbye"
echoer ! "You're just repeating everything I say"

import fpinscala.parallelism.Nonblocking.Par._

val p = parMap(List.range(1, 20))(math.sqrt(_))
val x = run(Executors.newFixedThreadPool(2))(p)

