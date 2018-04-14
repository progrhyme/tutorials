import fpinscala.state._

0x5DEECE66DL

0xBL

case class SimpleRNG(seed: Long) extends RNG {
  def nextInt: (Int, RNG) = {
    val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
    val nextRNG = SimpleRNG(newSeed)
    val n = (newSeed >>> 16).toInt
    (n, nextRNG)
  }
}

val rng = SimpleRNG(42)
val (n1, rng2) = rng.nextInt
val (n2, rng3) = rng2.nextInt

RNG.unit(4)(rng)._1
RNG.unit(3.0)(rng)._1

RNG.map(RNG.nonNegativeInt)(_ / Int.MaxValue.toDouble)(rng)

Int.MaxValue

RNG.nonNegativeInt(rng)

val i = 2147483647 - 3647
val n = 20000
val mod = i % n
i + (n-1) - mod // overflow

def rollDie: RNG.Rand[Int] = RNG.map(RNG.nonNegativeLessThan(6))(_ + 1)

val zero = rollDie(SimpleRNG(5))._1
