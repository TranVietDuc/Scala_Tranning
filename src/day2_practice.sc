import scala.collection.mutable
import scala.io.Source
import scala.reflect.io.File
//TEST TUPLES

var testTuple = (1, "string", 3.25)
print(testTuple._3);

//Test Map
val mutableMap = mutable.Map[Int, String]()

mutableMap += (1-> "Hello")
mutableMap += (2-> "there")

val romanNumeral = Map( 1 -> "H", 2 -> "i", 3-> "!")
print(romanNumeral(1))

def printArg(args: Array[String]): Unit = {
  for (arg <- args)
    println(arg)
}

val testArray = Array.apply("h", "e", "l");
printArg(testArray)


val fileName = "/Users/duc_tv/IdeaProjects/scalar_test/app/untitled.sc";
def readLines(filename: String): Unit = {
  for (line <- Source.fromFile(fileName).getLines()) {
    println(line)
  }
}

//readLines(fileName)

var smpDouble = 5.5 ;
smpDouble = smpDouble.unary_-;

//test functional object
class Rational(n: Int, d: Int) {
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  val numer = n / g
  val denom = d / g
  def this(n: Int) = this(n, 1)
  def + (that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  def * (that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)
  def * (that: Int): Rational =
    new Rational((numer * that),denom)
  override def toString = numer + "/" + denom
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

val rational = new Rational(2 , 3)
rational.toString
//rational.add(new Rational(3,2))
val rational2 = new Rational(4)
//implicit Conversion]

val s = new Rational(2/3).*(3)

//composition and inheritance
abstract class Element {
  def contents: Array[String]
  val height = contents.length
  val width = if(height == 0) 0 else contents(0).length
  def above(that : Element): Element =
    new ArrayElement(this.contents ++ that.contents)

  def beside(that: Element):Element =
    new ArrayElement(
      for (
        (line1, line2) <- this.contents zip that.contents
      ) yield line1 + line2
    )
  override def toString = contents mkString "\n"
}

class ArrayElement(conts: Array[String]) extends Element{
  final override def contents: Array[String] = conts
}

val testEx: Element = new ArrayElement(Array("hello", "there"))
print(testEx.height)
print(testEx.width)
val test2: ArrayElement = new ArrayElement(Array("hi", "there","duc"))


class LineElement(s: String) extends ArrayElement(Array(s)){
  override val height: Int = 1
  override val width: Int = s.length
}



