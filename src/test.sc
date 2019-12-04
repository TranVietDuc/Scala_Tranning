def sockMerchant(a: Array[Int]): Int = {

  def countTimeAppear(num: Int, listOrigin: Array[Int]): Int = {
    var count = 0
    for ( j <- listOrigin
          if (j == num)) count += 1
    count
  }

  val arrayDistinct = a.distinct
  val coupleOfEachColor = arrayDistinct.map(x => countTimeAppear(x, a)).map(x => x/2)
  val numOfCouple = coupleOfEachColor.sum

  numOfCouple
}

val a = Array(10, 20, 20, 10, 10, 30, 50, 10, 20)
def countTimeAppear(num: Int, listOrigin: Array[Int]): Int = {
  var count = 0
  for ( j <- listOrigin
        if (j == num)) count += 1
  count
}

val arrayDistinct = a.distinct
val coupleOfEachColor = arrayDistinct.map(x => countTimeAppear(x, a)).map(x => x/2)
val numOfCouple = coupleOfEachColor.sum