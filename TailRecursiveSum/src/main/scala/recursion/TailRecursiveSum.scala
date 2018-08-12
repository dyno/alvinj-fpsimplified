package recursion

import scala.annotation.tailrec

object TailRecursiveSum extends App {

  // call sum
  println(sum(List.range(1, 10)))

  // the tail-recursive version of sum
  def sum(list: List[Int]): Int = {
    @tailrec
    def sumWithAccumulator(list: List[Int], currentSum: Int): Int = {
      list match {
        case Nil => {
          val stackTraceAsArray = Thread.currentThread.getStackTrace
          stackTraceAsArray.foreach(println)
          currentSum
        }
        case x :: xs => sumWithAccumulator(xs, currentSum + x)
      }
    }
    sumWithAccumulator(list, 0)
  }

}
