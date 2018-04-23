import org.scalacheck._
import org.scalacheck.Prop.forAll

val intList = Gen.listOf(Gen.choose(0, 100))
val prop =
  forAll(intList)(ns => ns.reverse.reverse == ns) &&
  forAll(intList)(ns => ns.headOption == ns.reverse.lastOption)
val failingProp = forAll(intList)(ns => ns.reverse == ns)

prop.check
failingProp.check

val sumProp =
  forAll(intList)(ns => ns.sum == ns.reverse.sum) &&
  forAll(intList)(ns => ns.sum >= ns.headOption.getOrElse(0))

sumProp.check

import fpinscala.testing.{Gen => Gen2}
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

Gen2.boolean.sample.run.apply(rng)

val gen01 = Gen2.boolean.map(b => if(b) 1 else 0)

