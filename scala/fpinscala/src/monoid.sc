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
val propIntAdditionMonoid = monoidLaws(Monoid.intAddition, Gen.choose(-100, 100))
val propIntMultiplyMonoid = monoidLaws(Monoid.intMultiplication, Gen.choose(-100, 100))
val propBoolOrMonoid = monoidLaws(Monoid.booleanOr, Gen.boolean)
val propBoolAndMonoid = monoidLaws(Monoid.booleanAnd, Gen.boolean)

Prop.run(propStringMonoid)
Prop.run(propIntAdditionMonoid)
Prop.run(propIntMultiplyMonoid)
Prop.run(propBoolOrMonoid)
Prop.run(propBoolAndMonoid)

// Ex 10.10

sealed trait WC
case class Stub(chars: String) extends WC
case class Part(lStub: String, words: Int, rStub: String) extends WC

val partMonoid = new Monoid[Part] {
  def op(a1: Part, a2: Part) = {
    if (a1.rStub == "" && a2.lStub == "") {
      Part(a1.lStub, a1.words + a2.words, a2.rStub)
    } else {
      Part(a1.lStub, a1.words + a2.words + 1, a2.rStub)
    }
  }
  val zero = Part("", 0, "")
}

// Ex 10.16

def productMonoid[A,B](A: Monoid[A], B: Monoid[B]): Monoid[(A, B)] =
  new Monoid[(A, B)] {
    def op(x: (A, B), y: (A, B)) =
      (A.op(x._1, y._1), B.op(x._2, y._2))
    val zero = (A.zero, B.zero)
  }

def mapMergeMonoid[K,V](V: Monoid[V]): Monoid[Map[K,V]] =
  new Monoid[Map[K,V]] {
    def zero = Map[K,V]()

    def op(a: Map[K,V], b: Map[K,V]) =
      (a.keySet ++ b.keySet).foldLeft(zero) { (acc, k) =>
        acc.updated(k, V.op(a.getOrElse(k, V.zero), b.getOrElse(k, V.zero)))
      }
  }

val intAddition: Monoid[Int] = new Monoid[Int] {
  def op(x: Int, y: Int) = x + y
  val zero = 0
}

val M: Monoid[Map[String, Map[String, Int]]] = mapMergeMonoid(mapMergeMonoid(intAddition))

val m1 = Map("o1" -> Map("i1" -> 1, "i2" -> 2))
val m2 = Map("o1" -> Map("i2" -> 3))
val m3 = M.op(m1, m2)

Monoid.bag(Vector("aaa", "bbb", "ccc", "aaa", "ddd", "bbb", "bbb"))