import java.awt.Point
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession

@main def scala_tour(): Unit =
  println("Hello, Scala Tour!")

  // Create an instance of the HelloScala class.
  // The class is in the same package as this Main class.
  val helloScala = new HelloScala()

  def say_hello : Unit = 
    /* 
      Calls the methods in the HelloScala class.
     */

    // From Getting Started on Scala Tour.
    helloScala.hello_world()
    helloScala.hello_values()
    helloScala.hello_variables()
    helloScala.hello_blocks()
    helloScala.hello_functions()
    helloScala.hello_methods()

    // Additional examples from beyond the Scala Tour.
    helloScala.hello_pattern_matching()
    helloScala.hello_primitives()
    helloScala.hello_references()
    helloScala.hello_exception()
    helloScala.hello_high_order_functions()
    helloScala.hello_maps()
  say_hello

  // Create an instance of the HelloSpark class.
  // The class is in the same package as this Main class.
  val helloSpark = new HelloSpark()
  def say_hello_spark : Unit = 
    /* 
      Calls the methods in the HelloSpark class.
      The HelloSpark class extends the HelloScala class.
     */
    helloSpark.hello_world()

    // Set up the sample data.
    // ! helloSpark.create_sample_csv()

    // Read the sample data into a Spark DataFrame.
    // The filepath is defined as a constant in the HelloSpark class to keep things simple.
    // ! helloSpark.read_spark_df()

  say_hello_spark





