val scala3Version = "3.5.0"
val sparkVersion = "3.5.2"
lazy val root = project
  .in(file("."))
  .settings(
    name := "scala-tour",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test,
  
    libraryDependencies ++= Seq(
    ("org.apache.spark" %% "spark-sql" % "3.2.0").cross(CrossVersion.for3Use2_13)
    ),
    libraryDependencies ++= Seq(
    ("org.apache.spark" %% "spark-core" % "3.2.0").cross(CrossVersion.for3Use2_13)
    ),
    libraryDependencies ++= Seq(
    ("org.apache.spark" %% "spark-streaming" % "3.2.0").cross(CrossVersion.for3Use2_13)
    ),
  )
  