//practice 1
for( i <- 0 to 4 ) println("hello word!")
//practice 2 - FizzBuzz
def printFizzBuzz(n: Int) = {
  val listInput = (for (i <- 1 to n) yield i).toList
  for( e <- listInput ) {
    val fizzBuzz = e % 15 == 0
    val fizz = (!fizzBuzz &&  e % 3 == 0)
    val buzz = (!fizzBuzz &&  e % 5 == 0)
    val normal = !(fizz || buzz || fizzBuzz)
    if (fizzBuzz) print("fizzBuzz")
    if(fizz) print("fizz")
    if(buzz) print("buzz")
    if (normal) print(e)
    print(" ")
  }
}
printFizzBuzz(15)
//practice 3 - PrimeNumber

def checkPrimeAndPrint(n: Int) = {
  def checkPrime(a: Int): Boolean = {
    if (a < 2) false
    else {
      var count = 0
      for (i <- 2 to a-1) {
        if (a % i == 0) count += 1
      }
      if (count == 0) true
      else false
    }
  }

  val listPrimeUnder =
    (for (i <- 1 to n - 1
          if checkPrime(i)) yield i).toList

  checkPrime(n) match {
    case true => println(n + " :is Prime")
    case _ => println(n + " :is not Prime")
  }
  listPrimeUnder match {
    case Nil => println("No under Prime")
    case _ => print("Under Prime: "); for (i <- listPrimeUnder) print(i + ",")
  }

}
checkPrimeAndPrint(8)