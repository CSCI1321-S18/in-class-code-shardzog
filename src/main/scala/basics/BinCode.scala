package basics
import scala.collection.mutable._

object BinCode extends App {
  def fitObjectsInBins(binSize: Array[Double], objSize: Array[Double]): Boolean = {
    val queue = Queue[Array[Double]]()
    val nextN = Queue[Int]()
    val objct = objSize(0)
    for (bin <- 0 until binSize.length) {
      if (binSize(bin) >= (objct - .01)) {
        val falseBins = binSize
        falseBins(bin) -= objct
        queue.enqueue(falseBins.clone)
        nextN.enqueue(1)
        falseBins(bin)+=objct
      }
    }
    var fits = if(queue.isEmpty) false else true
    var queued = false
    var done = false
    while (!queue.isEmpty && !done) {
      val current = queue.dequeue()
      val n = nextN.dequeue()
      for (bin <- 0 until current.length) {
        if (current(bin) > (objSize(n) - .01)) {
          val fakeBins = current
          fakeBins(bin) -= objSize(n)
          if((n+1)<objSize.length) {
            queue.enqueue(fakeBins.clone)
            nextN.enqueue(n+1)
          } else {
            fits = true
            done = true
          }
          fakeBins(bin) += objSize(n)
          queued = true
        } else if(bin>=(current.length-1) && !queued) fits = false
      }
      queued = false
    }
    fits
  }

  val arr1 = Array(4, 3)
  val arr2 = Array(3, 2, 2)
  val arr3 = Array(5, 2)
  val arr4 = Array(2, 3, 8)
  val arr5 = Array(2, 4, 6)
  println(fitObjectsInBins(arr1.map(_.toDouble), arr2.map(_.toDouble)))
  println(fitObjectsInBins(arr1.map(_.toDouble), arr3.map(_.toDouble)))
  println(fitObjectsInBins(arr4.map(_.toDouble), arr5.map(_.toDouble)))
}