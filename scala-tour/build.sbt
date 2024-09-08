val scala3Version = "3.5.0"
val sparkVersion = "3.5.2"
lazy val root = project
  .in(file("."))
  .settings(
    name := "scala-tour",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test,
    // libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.5.0" % "provided",
    // https://mvnrepository.com/artifact/org.apache.spark/spark-core
    // libraryDependencies += "org.apache.spark" %% "spark-core" % "3.5.0",
    // use the cross version of the Scala library
    //libraryDependencies += "org.apache.spark" % "spark-core_2.12" % "3.5.0",
    //libraryDependencies += "org.apache.spark" % "spark-sql_2.12" % "3.5.0"
    // A cross version of the Scala library is used to ensure that the correct version of the library is used for the Scala version that you are using.

    libraryDependencies ++= Seq(
    ("org.apache.spark" %% "spark-sql" % "3.2.0" % "provided").cross(CrossVersion.for3Use2_13)
    ),
    libraryDependencies ++= Seq(
    ("org.apache.spark" %% "spark-core" % "3.2.0" % "provided").cross(CrossVersion.for3Use2_13)
    )


    //fork / run := true,
    // include the 'provided' Spark dependency on the classpath for <code>sbt run
   // Compile / run := Defaults.runTask(Compile / fullClasspath, Compile / run / mainClass, Compile / run / runner).evaluated 
  )
  