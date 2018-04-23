import fpinscala.testing._
import fpinscala.testing.Prop.forAll
import fpinscala.state._

case class SimpleRNG(seed: Long) extends RNG {
  def nextInt: (Int, RNG) = {
    val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
    val nextRNG = SimpleRNG(newSeed)
    val n = (newSeed >>> 16).toInt
    (n, nextRNG)
  }
}

val rng = SimpleRNG(42)

Gen.boolean.sample.run.apply(rng)

val gen01 = Gen.boolean.map(b => if(b) 1 else 0)

val smallInt = Gen.choose(-10, 10)
val maxProp = forAll(Gen.listOf(smallInt)) { ns =>
  val max = ns.max
  !ns.exists(_ > max)
}
