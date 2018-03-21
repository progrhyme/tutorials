/* Expressions */
1 + 1

println(1)
println(1 + 1)
println("Hello!")
println("Hello," + " world!")

// Values
val x = 1 + 1
println(x)

val y = 1 + 1
//y = 3

val z: Int = 1 + 1

// Variables
var v = 1 + 1
v = 3
println(v * v)

var w: Int = 1 + 1

/* Blocks */
println({
  val x = 1 + 1
  x + 1
})

/* Functions */
(x: Int) => x + 1

val addOne = (x: Int) => x + 1
println(addOne(1))

val getTheAnswer = () => 42
println(getTheAnswer())
