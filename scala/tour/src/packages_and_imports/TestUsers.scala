package packages_and_imports

object TestUsers extends App {
  import users._
  val u = new User
  println(u)
}
