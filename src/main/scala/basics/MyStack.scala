package basics

trait MyStack[A] {
  def push(a: A): Unit
  def pop(): A //changes things
  def peek: A
  def isEmpty: Boolean
}