def printName(first: String, last: String): Unit = {
  println(first + " " + last)
}

printName("John", "Smith")
printName(first = "John", last = "Smith")
printName(last = "Smith", first = "John")

//printName(last = "Smith", "john")
//Error:(9, 94) positional after named argument.
