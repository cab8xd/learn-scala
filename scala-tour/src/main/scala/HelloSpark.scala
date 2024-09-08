/* 
    This is the HelloSpark class that extends the HelloScala class.
    The HelloSpark class is in the same package as the HelloScala class.

    ? What is Apache Spark?
    Apache Spark is an open-source distributed general-purpose cluster-computing framework.
    Spark provides an interface for programming entire clusters with implicit data parallelism and fault tolerance.
    With Scala, you can use Spark to process large datasets.
 */
import org.apache.spark.sql.SparkSession
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

        val spark = SparkSession.builder
        .appName("HelloWorld")
        .master(sys.env.getOrElse("SPARK_MASTER_URL", "local[*]"))
        .getOrCreate()           // 1
        import spark.implicits._   // 2

        val df = List("hello", "world").toDF  // 3
        df.show()

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
        writer.write("id,name,age,city\n")
        writer.write("1,Alice,25,New York\n")
        writer.write("2,Bob,30,Los Angeles\n")
        writer.write("3,Charlie,35,Chicago\n")
        writer.write("4,David,40,Houston\n")
        writer.write("5,Eve,45,Phoenix\n")
        
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
        // Create a Spark dataframe.
        // Read the CSV file into a DataFrame.
        // Create a Spark session.
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
