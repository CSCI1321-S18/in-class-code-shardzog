package basics

import io.StdIn._
/**
 * This is a basic main for you to start off with.
 */
object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello World!")
    println("What is your name?")
    val name = readLine
    println("Hello " + name)
  }

  def square(x: Double) = x * x

  def cube(x: Double) = x * x * x
}
