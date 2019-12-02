import java.io.File

//Extractor in Pattern Matching
object Twice {
  def apply(s: String): String = s + s

  def unapply(s: String): Option[String] = {
    val halfLength = s.length/2
    val half = s.substring(0,halfLength)
    if (half == s.substring(halfLength)) Some(half) else None
  }
}

object UpperCase {
  def unapply(a: String): Boolean = {
    if (a.toUpperCase == a) true
    else false
  }
}

//def userTwiceUpper(s:String) = s match  {
//  case EMail(Twice(x @ UpperCase()), domain) => "match: " + x + " in domain" + domain
//  case _ => "no match"
//}

//userTwiceUpper("DIDI@hotmail.com");

//first-class functions
//assign function as Variable
val double = (i: Int) => {i*2}
double(3)
//pass as Params
def operation(functionparam: (Int, Int) => Int): Unit = {
  println(functionparam(10,5))
}
val sum = (x: Int, y : Int) => x+y

operation(sum)
//return a function

//place holder syntax
val f = (_:Int) + (_: Int)
f(1,2)

//closure:
var c = 7
val sum1 = (a: Int, b: Int) => (a+b)*c
sum1(3,4)

c =9
sum1(3,4)

var age = 22
val sayHello = (s: String) => println(s"I am $s and I am $age")
sayHello("duc")

def func(f:String => Unit, s: String): Unit ={
  f(s)
}

func(sayHello,"DUC")

//repeated Params
def echo(args: String*): Unit ={
  for (arg <- args) println(arg)
}


//Control Abstraction
object FileMatcher {
  private def filesHere = (new File(".")).listFiles()

  private def fileMatching(matcher: String => Boolean) = {
    for (file <- filesHere; if matcher(file.getName))
      yield file
  }

  def filesEnding(query: String) =
    fileMatching(_.endsWith(query))

  def filesContaining(query: String) = fileMatching(_.contains((query)))

  def filesRegex(query: String) = fileMatching(_.matches(query))
}

def containOdd(nums: List[Int]) = nums.exists(_ %2 ==0)

containOdd(List(0,1,2))
containOdd(List(1,3,5))