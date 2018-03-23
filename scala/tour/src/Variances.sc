class Foo[+A] // A covariant class
class Bar[-A] // A contravariant class
class Baz[A]  // An invariant class

// Covariance
abstract class Animal {
  def name: String
}
case class Cat(name: String) extends Animal
case class Dog(name: String) extends Animal

// example using class List[+A]
//object CovarianceTest extends App {
  def printAnimalNames(animals: List[Animal]): Unit = {
    animals.foreach { animal =>
      println(animal.name)
    }
  }

  val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
  val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))

  printAnimalNames(cats)
  // Whiskers
  // Tom

  printAnimalNames(dogs)
  // Fido
  // Rex
//}

def printCatNames(cats: List[Cat]): Unit = {
  cats.foreach { cat => println(cat.name) }
}

printCatNames(cats)
//printCatNames(dogs) // Compilation Error!

// Contravariance
abstract class Printer[-A] {
  def print(value: A): Unit
}

class AnimalPrinter extends Printer[Animal] {
  def print(animal: Animal): Unit =
    println("The animal's name is: " + animal.name)
}

class CatPrinter extends Printer[Cat] {
  def print(cat: Cat): Unit =
    println("The cat's name is: " + cat.name)
}

val myCat: Cat = Cat("Boots")

def printMyCat(printer: Printer[Cat]): Unit = {
  printer.print(myCat)
}

val catPrinter: Printer[Cat] = new CatPrinter
val animalPrinter: Printer[Animal] = new AnimalPrinter

printMyCat(catPrinter)
printMyCat(animalPrinter)

// Invariance
class Container[A](value: A) {
  private var _value: A = value
  def getValue: A = _value
  def setValue(value: A): Unit = {
    _value = value
  }
}

val catContainer: Container[Cat] = new Container(Cat("Felix"))
//val animalContainer: Container[Animal] = catContainer // Compilation Error!
//animalContainer.setValue(Dog("Spot"))
val cat: Cat = catContainer.getValue
