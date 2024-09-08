// TODO: Improve comments to explain the code. 
// ? What is the best practice for comments in Scala--To describe methods, classes, and variables?
/*
 The HelloScala class comprises of methods. 
 Each method can exemplify Scala basic syntax and semantics.
 The examples include values, variables, blocks, functions, and methods.
*/

class HelloScala() {

  def hello_world(): Unit = {
    println("Hello world!")
    println(msg) // Calls the msg method below.
    println("Goodbye world!\n")
  }
  def msg = "I was compiled by Scala 3. :)" 

  def hello_values(): Unit = {
    /*
    Demonstrates the use of values in Scala. 
    @param: None.
    Values are immutable; they cannot be changed once they are defined.
     */
    println("Hello values!")
    val x = 1
    val y: Int = 2
    val z = x + y
    println(z) // 3
    println("val x: " + x) // 1
    println("Goodbye values!\n")
  }

  def hello_variables(): Unit = {
    /* 
    Demonstrates the use of variables in Scala.
    @param: None.
    @return: None.
    Variables are mutable; they can be changed after they are defined.
     */
    println("Hello variables!")
    var a = 1
    var b: Int = 2
    var c = a + b
    println("var c:" + c) // 3
    a = 3
    println("var a: " + a) // 3
    println("var c: " + c) // 3
    println("Goodbye variables!\n")
  }

  def hello_blocks(): Unit = 
    /* 
    Demonstrates the use of blocks in Scala.
    @param: None.
    @return: None.
    Blocks are expressions that have their own scope and return a value.
     */
    println("Hello blocks!")
    val result = {
      val x = 1 + 1
      x + 1
    } // 3
    println(result)
    println("Goodbye blocks!\n")


  def hello_functions(): Unit = {
    /*
    Demonstrates the use of functions in Scala.
    @param: None.
    @return: None.
    Functions are expressions that take parameters and return a value.
    */
    println("Hello functions!")
    // Anonymous 
    //(x: Int) => x + 1 
    //println((x: Int) => x + 1) // <function1>

    // Named
    val addOne = (x: Int) => x + 1
    println(addOne(1)) // 2

    // Multiple parameters
    val add = (x: Int, y: Int) => x + y
    println(add(1, 2)) // 3

    // No parameters
    val getTheAnswer = () => 42
    println(getTheAnswer()) // 42

    // Function with side effects
    var i = 0
    val increment = () => i += 1
    println(increment()) // () because the function has side effects.
    // A side effect is an effect that a function has outside of its return value.
    // For example, a side effect could be writing to a file, modifying a global variable, or printing to the console.
    // In this case, the side effect is modifying the global variable i.
    println(i) // 1

    // Function with multiple expressions.
    val addThenDouble = (x: Int, y: Int) => {
      val a = x + y
      a * 2
    }
    println(addThenDouble(1, 2)) // 6

    println("Goodbye functions!\n")
  }

  def hello_methods(): Unit = {
    /*
    Demonstrates the use of methods in Scala.
    @param: None.
    @return: None.
    Methods are functions that are members of a class, object, or trait.
    A method can have multiple parameter lists, multiple expressions, and no parameters.
    We can nest methods inside other methods.
    */
    println("Hello methods!")
    def addMethod(x: Int, y: Int): Int = x + y
    println(addMethod(1, 2)) // 3

    // Method with multiple parameter lists.
    def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
    println(addThenMultiply(1, 2)(3)) // 9

    // Method with multiple expressions.
    def addThenDoubleMethod(x: Int, y: Int): Int = {
      val a = x + y
      a * 2
    }
    println(addThenDoubleMethod(1, 2)) // 6

    // Method with no parameters.
    def name: String = System.getProperty("user.name")
    println("Hello, " + name + "!\n")

    // Method with multiline expressions.
    // ! Note
    // The return type of the method is inferred to be String.
    // The return keyword is not needed.
    def getSquareString(input: Double): String =
      val square = input * input
      square.toString
    println(getSquareString(2.5)) // 6.25

    // Method with no return value.
    def printSquare(input: Double): Unit =
      println(getSquareString(input))
    printSquare(2.5) // 6.25
    
    println("Goodbye methods!\n")
  }

  def hello_pattern_matching(): Unit = {
    /*
    Demonstrates the use of pattern matching in Scala.
    @param: None.
    @return: None.
    Pattern matching allows you to match a value against a pattern.
    Similar to a switch statement in other languages.
    */
    println("Hello pattern matching!")
    val x: Int = 1
    println("x is " + x)
    x match
      case 1 => println("One")
      case 2 => println("Two")
      case _ => println("Other")

    println("Goodbye pattern matching!\n")
  }

  def hello_primitives(): Unit = {
    /*
    Demonstrates the use of primitive types in Scala.
    @param: None.
    @return: None.
    ! Unlike Java, Scala's primitives are objects.
    */
    println("Hello primitive types (objects)!")
    val x: Byte = 1
    val y: Short = 2
    val z: Int = 3
    val a: Long = 4
    val b: Float = 5.0f
    val c: Double = 6.0
    val d: Char = 'a'
    val e: String = "Hello"
    val f: Boolean = true
    println(x) // 1
    println(y) // 2
    println(z) // 3
    println(a) // 4
    println(b) // 5.0
    println(c) // 6.0
    println(d) // a
    println(e) // Hello
    println(f) // true
    println("Goodbye primitive types (objects)!\n")
  }

  def hello_references(): Unit = {
    /*
    Demonstrates the use of references in Scala.
    @param: None.
    @return: None.
    References are used to refer to objects.
    */
    println("Hello references!")

    // Reference to a String object.
    val string = "A string can be referenced."
    println(string) // I am a reference object.

    // Reference to a List object.
    val list = List(1, 2, 3)
    println(list) // List(1, 2, 3)

    println("Goodbye references!\n")
  }

  def hello_exception(): Unit = {
    /*
    Demonstrates the use of immutable objects in Scala.
    @param: None.
    @return: None.
    Immutable objects cannot be changed after they are created.
    */
    println("Hello exception handling!")
    // Try catch block to handle exceptions.
    // Keep running the code even if an exception occurs.
    try
      val x = 1 / 0
      hello_world()
    catch
      case e: Exception => println(e)
    finally
      println("Finally block is always executed.")
      hello_world()

    
    println("Goodbye exception handling!\n")
  }

  def hello_high_order_functions(): Unit = {
    /*
    Demonstrates the use of high-order functions in Scala.
    @param: None.
    @return: None.
    High-order functions take other functions as parameters or return functions.
    */
    println("Hello high-order functions!")
    // This function takes an Int and returns a Int.
    val multiplyByTwo: Int => Int = (x: Int) => x * 2
    val result: Int = multiplyByTwo(5)
    println(result) // 10

    // Function that takes another function as a parameter.
    // This function takes an Int and returns a String.
    def apply(f: Int => String, v: Int): String = f(v)
    val doubler = (i: Int) => (i * 2).toString
    println(apply(doubler, 2)) // 4

    // Function that returns another function.
    // This function returns a function that takes an Int and returns an Int.
    def getMultiplier(): Int => Int = {
      val factor = 3
      (i: Int) => i * factor
    }
    val multiplier = getMultiplier()
    println(multiplier(3)) // 9

    println("Goodbye high-order functions!\n")
  }

  def hello_maps(): Unit = {
    /*
    Demonstrates the use of maps in Scala.
    @param: None.
    @return: None.
    Maps are collections of key-value pairs.
    */
    println("Hello maps!")
    // Create a map with key-value pairs.
    val map_a = Map("one" -> 1, "two" -> 2, "three" -> 3)
    println(map_a) // Map(one -> 1, two -> 2, three -> 3)

    // Access values in the map.
    println(map_a("one")) // 1
    println(map_a("two")) // 2
    println(map_a("three")) // 3

    // Add a new key-value pair to the map.
    println("Adding key 'four' to the map.")
    val map_b = map_a + ("four" -> 4)
    println(map_b) // Map(one -> 1, two -> 2, three -> 3, four -> 4)

    // Remove a key-value pair from the map.
    println(map_b) // Map(one -> 1, two -> 2, three -> 3, four -> 4)
    println("Removing key 'four' from the map.")
    val map_c = map_b - "four"
    println(map_c) // Map(one -> 1, two -> 2, three -> 3)

    // Apply a function to each key-value pair in the map.
    println("Doubling the values in the map.")
    val map_d = map_c.map { case (k, v) => (k, v * 2) }
    println(map_d) // Map(one -> 2, two -> 4, three -> 6)

    // Iterate over the map.
    println("Iterating over the map.")
    map_d.foreach { case (k, v) => println(s"key: $k, value: $v") }

    // Apply a filter to the map.
    // A filter is an operation that removes elements from a collection based on a predicate.
    println("Filtering the map.")
    println(map_d) // Map(one -> 2, two -> 4, three -> 6)
    val mad_e = map_d.filter { case (k, v) => v % 2 == 0 }
    println(mad_e) // Map(two -> 2)

    // Apply a fold to the map.
    // A fold is an operation that combines the elements of a collection using a binary operator.
    // The foldLeft method starts with an initial value and applies the binary operator from left to right.
    println("Folding the map.")
    println(map_d) // Map(one -> 2, two -> 4, three -> 6)
    val sum = map_d.foldLeft(0) { case (acc, (k, v)) => acc + v }
    println(sum) // 12

    // Reduce the map.
    // The reduce method combines the elements of a collection using a binary operator.
    // The reduceLeft method starts with the first element and applies the binary operator from left to right.
    println("Reducing the map.")
    println(map_d) // Map(one -> 2, two -> 4, three -> 6)
    val product = map_d.map { case (k, v) => v }.reduceLeft(_ * _)
    println(product) // 48

    // ? What's the difference between fold and reduce?
    // The fold method takes an initial value, while the reduce method does not.
    // The fold method is safe to use with empty collections, while the reduce method is not.

    println("Goodbye maps!\n")
  }
}
