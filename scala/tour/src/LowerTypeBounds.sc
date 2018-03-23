/**
  * Codes below don't work because functions are contravariant in their parameter
  * types and covariant in their result types
  */
//trait Node[+B] {
//  def prepend(elem: B): Node[B]
//}

//case class ListNode[+B](h: B, t: Node[B]) extends Node[B] {
//  def prepend(elem: B): ListNode[B] = ListNode(elem, this)
//  def head: B = h
//  def tail: Node[B] = t
//}

//case class Nil[+B]() extends Node[B] {
//  def prepend(elem: B): ListNode[B] = ListNode(elem, this)
//}

trait Node[+B] {
  def prepend[U >: B](elem: U): Node[U]
}

case class ListNode[+B](h: B, t: Node[B]) extends Node[B] {
  def prepend[U >: B](elem: U): ListNode[U] = ListNode(elem, this)
  def head: B = h
  def tail: Node[B] = t
}

case class Nil[+B]() extends Node[B] {
  def prepend[U >: B](elem: U): ListNode[U] = ListNode(elem, this)
}

trait Bird
case class AfricanSwallow() extends Bird
case class EuropeanSwallow() extends Bird

val africanSwallowList= ListNode[AfricanSwallow](AfricanSwallow(), Nil())
africanSwallowList.head
africanSwallowList.tail

val birdList: Node[Bird] = africanSwallowList
birdList.prepend(new EuropeanSwallow)

val birdList2: ListNode[Bird] = africanSwallowList
birdList2.prepend(new EuropeanSwallow)
