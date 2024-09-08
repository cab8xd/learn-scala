/* 
    This is the HelloSpark class that extends the HelloScala class.
    The HelloSpark class is in the same package as the HelloScala class.

    ? What is Apache Spark?
    Apache Spark is an open-source distributed general-purpose cluster-computing framework.
    Spark provides an interface for programming entire clusters with implicit data parallelism and fault tolerance.
    With Scala, you can use Spark to process large datasets.
 */

 // ! The class is bugged due to dependency issues. 
 // ! The code should be correct but the dependencies are not working properly.
 // https://onecompiler.com/scala/3y9a9k988
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.{SparkSession, DataFrame, Row}
import org.apache.spark.sql.types._
import javax.xml.transform.Source
import java.io.File
import java.io._

class HelloSpark extends HelloScala {
    // Constants to manage sample data.
    val resources_file_path = "src/main/resources/"
    val sample_csv_file_path = resources_file_path + "sample.csv"

    // Override the hello_world method.
    override def hello_world(): Unit = {
        println("Let's override the hello_world method in the HelloSpark class.")
        println("Hello, Spark! This is the HelloSpark class that extends the HelloScala class.")

        // Create basic Spark Session.
        val spark = SparkSession.builder
            .appName("HelloSpark")
            .master("local")
            .getOrCreate()
        print("Session created")
        import spark.implicits._

        // Define schema for DataFrame
        val schema = StructType(Seq(
        StructField("First", StringType, nullable = false),
        StructField("Second", StringType, nullable = false),
        StructField("Third", StringType, nullable = false)
        ))

        // Sample data: List of Lists
        val data = List(
        List("Hello", "Data", "Frame"),
        )

        // Convert List of Lists to RDD of Rows
        val rowsRDD = spark.sparkContext.parallelize(data).map(Row.fromSeq)

        // Create DataFrame
        val df: DataFrame = spark.createDataFrame(rowsRDD, schema)
       
        df.show() // The show() method is a part of the Apache Spark DataFrame API and provides basic visualization.
        spark.stop()     
    }

    // Methods to manage sample data.
    def create_sample_csv(): Unit = {
        /* 
            Create a sample CSV file.
            The CSV file will be used in the Spark examples.

            The CSV file will have the following columns:
            - id
            - name
            - age
            - city

            The CSV file will have the following rows:
            - 1, Alice, 25, New York
            - 2, Bob, 30, Los Angeles
            - 3, Charlie, 35, Chicago
            - 4, David, 40, Houston
            - 5, Eve, 45, Phoenix
         */

        // If the file already exists, ask the user if they want to delete it.
        val file = new File(sample_csv_file_path)
        if (file.exists) {
            println("The sample CSV file already exists.")
            println("Do you want to delete the file? (yes/no)")
            val response = scala.io.StdIn.readLine()
            if (response == "yes") {
                delete_file(sample_csv_file_path)
            } else {
                println("The sample CSV file will not be created.")
                return
            }
        }

        // Write the file to the src/main/resources directory.
        val writer = new PrintWriter(new File(sample_csv_file_path))
        // Make a list of rows
        val rows = List(
            "id,name,age,city",
            "1,Alice,25,New York",
            "2,Bob,30,Los Angeles",
            "3,Charlie,35,Chicago",
            "4,David,40,Houston",
            "5,Eve,45,Phoenix"
        )
        writer.write(rows.mkString("\n"))
        writer.close()

        println("The sample CSV file has been created.")
    }

    def delete_file(file_path: String): Unit = {
        /* 
            Delete a file.
            @param file_path: the path to the file to delete.
         */

        val file = new File(file_path)
        if (file.delete) {
            println(s"Deleted the file: $file_path")
        } else {
            println(s"Failed to delete the file: $file_path")
        }
    }

    // Methods to create Spark DataFrames.
    def read_spark_df(): Unit = {
        /* 
            Read a CSV file into a Spark DataFrame.
            The CSV file will be used in the Spark examples.
         */
        val spark = SparkSession
        .builder
        .appName("HelloSpark")
        .config("spark.master", "local")
        .getOrCreate()

        val df = spark.read
            .option("header", "true")
            .option("inferSchema", "true")
            .csv(sample_csv_file_path)

        // Show the DataFrame.
        df.show()   
    }




        




  
}
