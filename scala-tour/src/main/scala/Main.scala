import java.awt.Point
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession
import org.apache.log4j.Logger

@main def scala_tour(): Unit =
  // Example of using the Apache log4j library.
  val logger = Logger.getLogger(getClass.getName)
  logger.info("Hello, Scala Tour!")


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

  val spark = SparkSession.builder
        .appName("HelloSpark")
        .master("local")
        .getOrCreate()
  import spark.implicits._
  print("Spark session created.")

  // Create an instance of the HelloSpark class.
  // The class is in the same package as this Main class.
  val helloSpark = new HelloSpark(spark)
  def say_hello_spark : Unit = 
    /* 
      Calls the methods in the HelloSpark class.
      The HelloSpark class extends the HelloScala class and exemplifies Apache Spark use cases.
      @param: None
      @return: None
     */
      // Call the hello_world method in the HelloSpark class.
      // The hello_world method is overridden in the HelloSpark class.
      helloSpark.hello_world()

      // Set up sample data.
      helloSpark.create_sample_csv()

      // Read the sample data into a Spark DataFrame.
      // The filepath is defined as a constant in the HelloSpark class to keep things simple.
      var df = helloSpark.read_spark_df()
      df.show()

      // Assert that the DataFrame is not empty.
      assert(df.count() > 0, "Unexpected behavior - The DataFrame is empty.")

      // Transformations and Manipulations
      // * Filter the DataFrame to include only 1 row via the default parameters.
      // Note that, to have some variety, the method has default parameters.
      var filtered_df = helloSpark.filter_df_if_equals(df)

      // Assert the filtered DataFrame has one row.
      assert(filtered_df.count() == 1, "The DataFrame should have one row.")
      filtered_df.show()

      // * Sort the DataFrame by a column.
      var sorted_df = helloSpark.sort_df_by_column(df, "Name")

      // Assert the first row of the sorted DataFrame.
      val first_row = sorted_df.first()
      assert(first_row(1) == "Alice", "The first row should have the name 'Alice'.")

      sorted_df.show()

      // * Aggregate the DataFrame.
      val avg_age_df = helloSpark.aggregate_df_avg(df, "city", "name")
      // This group by is a bit contrived; it's just to show the syntax.

      // * Join two DataFrames.
      // Create a second DataFrame.
      val df2 = helloSpark.read_spark_df()
      val joined_df = helloSpark.join_df(df, df2, "Name")
      joined_df.show()

      // Map df to a new DataFrame.
      val doubledAges = helloSpark.map_df(df)
      doubledAges.show()


  try {
    // Call the hello_spark method in the HelloSpark class.
    say_hello_spark
  } catch {
    case e: Exception => println(s"An exception occurred: ${e.getMessage}")
  }
  finally {
    // Stop the Spark session.
    spark.stop()
    println("Spark session stopped.")
  }









