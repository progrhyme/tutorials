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