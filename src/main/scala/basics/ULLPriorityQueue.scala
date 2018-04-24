package basics

class ULLPriorityQueue[A](hp: (A, A) => Boolean) extends MyPriorityQueue[A] {
  import ULLPriorityQueue._
  private var front: Node[A] = null
  private var back: Node[A] = null

  def enqueue(a: A): Unit = {
    val n = new Node(null, a, null)
    if (isEmpty) {
      front = n
      back = n
    } else {
      back.next = n
      back = n
    }
  }
  def dequeue(): A = {
    var rover = front
    var ret = front
    while (rover != back.next) {
      if (hp(rover.data, ret.data)) {
        ret = rover
      }
      rover = rover.next
    }
    ret.prev.next = ret.next
    ret.next.prev = ret.prev
    ret.data
  }
  def isEmpty: Boolean = front == null
  def peek: A = {
    var ret = front
    var rover = ret.next
    while (rover != back.next) {
      if (hp(rover.data, ret.data)) {
        ret = rover
      }
      rover = rover.next
    }
    ret.data
  }

}

object ULLPriorityQueue {
  private class Node[A](var prev: Node[A], val data: A, var next: Node[A])
}