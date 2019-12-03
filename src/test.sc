def primesReversion(a: Int, b: Int): Int = {
  def isPrime(a: Int): Boolean = {
    (a > 1 && ((2 until a - 1).filter(x => a % x == 0).isEmpty))
  }

  def group(a: List[Int]): List[(Int, Int)] = {
    for (a1 <- a; b1 <- a) yield (a1, b1)
  }

  def getSum(a : Int): Int ={
    var n = a
    var sum = 0
    var sotachra = 0;
    while (n != 0) {
       sotachra = n % 10
       sum += sotachra
       n = n / 10
    }
       sum
  }
  val listPrime = (a + 1 to b).filter(x => isPrime(x)).toList
  val listGroup = group(listPrime)
  val listResult = listGroup.filter(x => (x._1 <= x._2)).map(x => x._1 * x._2).map(x => getSum(x)).filter( x => isPrime(x))
  listResult.length
}

def isPrime(a: Int): Boolean = {
  (a > 1 && ((2 until a-1 ).filter(x => a % x == 0).isEmpty))
}

val x = isPrime(12)
val a = List(2,3,5,7)

def vain(a: List[Int]): List[(Int, Int)] = {
  for (a1 <- a; b1 <- a) yield (a1, b1)
}
val listPrime = (7 to 20).filter(x => isPrime(x)).toList
val c = vain(listPrime)
val d = c.filter(x => (x._1 <= x._2))
val e = d.map(x => x._1 * x._2)

def getSum(a : Int): Int ={
  var n = a
  var sum = 0
  var sotachra = 0;
  while (n != 0) {
    sotachra = n % 10
    sum += sotachra
    n = n / 10
  }
  sum
}
val f = e.map(x => getSum(x))
val k = f.filter( x => isPrime(x))



primesReversion(7, 20)