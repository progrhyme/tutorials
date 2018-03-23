import scala.util.Random

object CustomerID {
  def apply(name: String) = s"$name--${Random.nextLong}"

  def unapply(customerID: String): Option[String] = {
    val name = customerID.split("--").head
    if (name.nonEmpty) Some(name) else None
  }
}

val customer1ID = CustomerID("Sukyoung")  // same as CustomerID.apply("Sukyoung")
customer1ID match {
  case CustomerID(name) => println(name)  // prints Sukyoung
  case _ => println("Could not extract a CustomerID")
}

val customer2ID = CustomerID("Nico")
val CustomerID(name) = customer2ID
println(name)

customer2ID
val name2 = CustomerID.unapply(customer2ID).get

//val CustomerID(name3) = "--asdfasdfasdf" // scala.MatchError: --asdfasdfasdf (of class java.lang.String)
val CustomerID(name4) = "Foo--asdfasdfasdf"
