abstract class Animal {
  def name: String
}

abstract class Pet extends Animal {}

class Cat extends Pet {
  override def name: String = "Cat"
}

class Dog extends Pet {
  override def name: String = "Dog"
}

class Lion extends Animal {
  override def name: String = "Lion"
}

class Kitten extends Cat {
  override def name: String = "Kitten"
}

class PetContainer[P <: Pet](p: P) {
  def pet: P = p
}

val dogContainer = new PetContainer[Dog](new Dog)
val catContainer = new PetContainer[Cat](new Cat)
//val lionContainer = new PetContainer[Lion](new Lion)
//Error:(25, 6) type arguments [A$A7.this.Lion] do not conform to class PetContainer's type parameter bounds [P <: A$A7.this.Pet]

class KittenContainer[K >: Kitten](a: K) {
  def kitten: K = a
}
val kc = new KittenContainer[Kitten](new Kitten)
val cc = new KittenContainer[Cat](new Cat)
//val dc = new KittenContainer[Dog](new Dog)
//Error:(37, 6) type arguments [A$A55.this.Dog] do not conform to class KittenContainer's type parameter bounds [K >: A$A55.this.Kitten]

class SomeSeq[+X] {
  val elements = Seq[X]()
  def push[U >: X](obj: U): Seq[U] = elements :+ obj
}

val ss = new SomeSeq[Kitten]
ss.push(new Cat)
ss.elements foreach { e => println(e.name) }

val ss2 = new SomeSeq[Cat]
ss2.push(new Kitten)
ss2.elements foreach { e => println(e.name) }
