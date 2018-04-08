package fpinscala.datastructures

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B =
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }

  def tail[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(_, xs) => xs
  }

  def setHead[A](l: List[A], head: A): List[A] = Cons(head, tail(l))

  def drop[A](l: List[A], n: Int): List[A] = n match {
    case m if m <= 0 => l
    case 1 => tail(l)
    case _ => drop(tail(l), n - 1)
  }

  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Nil => Nil
    case Cons(head, _) if ! f(head) => l
    case Cons(head, xs) if f(head) => dropWhile(xs, f)
  }

  def append[A](a1: List[A], a2: List[A]): List[A] = a1 match {
    case Nil => a2
    case Cons(h, t) => Cons(h, append(t, a2))
  }

  def init[A](l: List[A]): List[A] = l match {
    case Nil => sys.error("init of empty list")
    case Cons(_, Nil) => Nil
    case Cons(x, y) => Cons(x, init(y))
  }

  def length[A](l: List[A]): Int = foldRight(l, 0)((_, y) => 1 + y)

  @annotation.tailrec
  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B =
    as match {
      case Nil => z
      case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
    }

  def sum2(ints: List[Int]): Int = foldLeft(ints, 0)((x, y) => x + y)
  def product2(ds: List[Double]): Double = foldLeft(ds, 1.0)(_ * _)
  def length2[A](l: List[A]): Int = foldLeft(l, 0)((x, _) => x + 1)

  def reverse[A](l: List[A]): List[A] = l match {
    case Cons(x, xs) => append(reverse(xs), Cons(x, Nil))
    case _ => l
  }

  def reverse2[A](l: List[A]): List[A] = foldLeft(l, List[A]())((x, y) => Cons(y, x))

  /*
  There's nothing particularly bad about this implementation,
  except that it's somewhat monolithic and easy to get wrong.
  Where possible, we prefer to assemble functions like this using
  combinations of other functions. It makes the code more obviously
  correct and easier to read and understand. Notice that in this
  implementation we need special purpose logic to break out of our
  loops early. In Chapter 5 we'll discuss ways of composing functions
  like this from simpler components, without giving up the efficiency
  of having the resulting functions work in one pass over the data.

  It's good to specify some properties about these functions.
  For example, do you expect these expressions to be true?

  (xs append ys) startsWith xs
  xs startsWith Nil
  (xs append ys append zs) hasSubsequence ys
  xs hasSubsequence Nil
  */
  @annotation.tailrec
  def startsWith[A](l: List[A], prefix: List[A]): Boolean = (l,prefix) match {
    case (_,Nil) => true
    case (Cons(h,t),Cons(h2,t2)) if h == h2 => startsWith(t, t2)
    case _ => false
  }

  @annotation.tailrec
  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = sup match {
    case Nil => sub == Nil
    case _ if startsWith(sup, sub) => true
    case Cons(h,t) => hasSubsequence(t, sub)
  }
}