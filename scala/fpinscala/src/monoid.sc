import fpinscala.monoids._

// Ex. 10.4

import fpinscala.testing._
import fpinscala.testing.Prop.forAll

def monoidLaws[A](m: Monoid[A], gen: Gen[A]): Prop =
  // Associativity
  forAll(for {
    x <- gen
    y <- gen
    z <- gen
  } yield (x, y, z))(p =>
    m.op(p._1, m.op(p._2, p._3)) == m.op(m.op(p._1, p._2), p._3)) &&
    // Identity
    forAll(gen)((a: A) =>
      m.op(a, m.zero) == a && m.op(m.zero, a) == a)


val propStringMonoid = monoidLaws(Monoid.stringMonoid, Gen.string(10))
Prop.run(propStringMonoid)

val propIntAdditionMonoid = monoidLaws(Monoid.intAddition, Gen.choose(-100, 100))
Prop.run(propIntAdditionMonoid)
