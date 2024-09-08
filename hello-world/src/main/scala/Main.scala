@main def hello(): Unit =
  println("Hello world!")
  println(msg)

def msg = "I was compiled by Scala 3. :)"

// Notes on how to run.
// 1. cd into the directory containing this file.
// 2. Run `sbt` to enter the SBT shell.
// 3. Run `run` to compile and run the code. Alternatively, run `~run` to watch for changes and recompile and rerun the code.
// 4. Press [Enter] to interrupt the run process.
// 5. Type `exit` to exit the SBT shell. Alternatively, press [Ctrl] + [D].