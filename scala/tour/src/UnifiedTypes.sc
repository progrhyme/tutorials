/* Scala Type Hierarchy */
val list: List[Any] = List(
  "a string",
  732,
  'c',
  true,
  () => "an anonymous function returning a string"
)

list.foreach(element => println(element))

/* Type Casting */
val x: Long = 987654321
val y: Float = x

val face: Char = '☺'
val number: Int = face

val x2: Long = 987654321
val y2: Float = x2
//val z2: Long = y2 // Compilation Error!

/* Nothing and Null */