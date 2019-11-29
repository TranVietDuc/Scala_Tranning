import java.io._

object Solution {
  // Answer
  def bubbleSort(arr: Array[Int]): Array[Int] = {
      for (i <- 1 to arr.length; j <- 1 to arr.length -1)
        if (arr(j-1) > arr(j)) {
          val temp = arr(j)
          arr(j) = arr(j-1)
          arr(j-1) = temp
        } yeil

}

val array = Array(7,2,6,4)
Solution.bubbleSort(array)