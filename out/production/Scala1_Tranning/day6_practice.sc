import scala.collection.immutable.TreeSet
import scala.collection.mutable

//Working with list
val fruit = "apple" :: "banana" :: "orange" :: Nil
fruit.tail; fruit.head

val nums = List(1,3,7,2,1)
val nums2 = List(1,2,3)
def insert(x: Int, xs: List[Int]): List[Int] =
  if (xs.isEmpty || x <= xs.head) x :: xs
  else xs.head :: insert(x, xs.tail)

def isort(xs: List[Int]): List[Int] =
  if (xs.isEmpty) Nil
  else insert(xs.head, isort(xs.tail))




isort(nums)

def isort1(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case x :: xs1 => insert(x, isort1(xs1))
}

isort1(nums)

def append[T](xs: List[T], ys: List[T]):List[T] =
  xs match {
    case List() => ys
    case x :: xs1 => x :: append(xs1, ys)
  }

append(nums2, nums)

val last =  nums2.last
val int = nums2.init
val head = nums2.head
val tail = nums2.tail
val reverse = nums2.reverse
val take2 = nums2.take(2)
val drop2 = nums2.drop(2)
val split2 = nums.splitAt(2)

val apply = nums apply 1
val getElement = nums(1)

List(nums).flatten
fruit.flatten
nums2.zipWithIndex
fruit.zipWithIndex

val arr2 = new Array[Int](3)
 nums copyToArray(arr2, 1)

arr2
//merge soft
def msort[T](less: (T,T) => Boolean)(xs: List[T]): List[T] = {
  def merge(xs: List[T], ys: List[T]): List[T] =
    (xs, ys) match {
      case (Nil, _) => ys
      case (_, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if(less(x,y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }
  val n = xs.length /2
  if(n == 0) xs
  else {
    val (ys, zs) = xs splitAt n
    merge(msort(less)(ys), msort(less)(zs))
  }
}

msort((x: Int, y :Int) => x > y)(nums)

val bol = Nil == List()

nums2 map(_ -1)

//practice underscore
val f2 = "Hello " + (_:String) + " Happy to meet " + (_:String)

f2("Duc", "Duc")

nums span(_ < 1)
val span1 = nums partition (_ > 1) _1

//sortWith

nums sortWith(_ > _)

//test convert mutable into immutable
val treeSet = TreeSet("blue", "green", "yellow")

var muteSet = mutable.Set.empty ++= treeSet

//Querying with for expressions
case class Book(title: String, author: String*)

val books = List(
  Book("Harry Potter",
  "JK","Duc","Park Han Seo"),
  Book("Scala in Programming",
  "Sep", "Bob", "Bill")
)

for ( a <- books; b <- a.author; if b startsWith("Duc")) yield a.title
for (b <- books ;
     if (b.title.indexOf("Programming") >= 0)) yield  b.author

// recursive
def removeDuplicate[A](xs: List[A]) : List[A] = {
  if (xs.isEmpty) xs
  else
    xs.head :: removeDuplicate(xs.tail filter(x => x != xs.head))
}
//practice translation for expression
var titleOfDucBook = books.withFilter(_.author.startsWith("Duc")).map(_.title)


//test Stream
def isPrime(num: Int) =
  num > 1 && !(2 to num -1 ).exists(e => num % e == 0)
var dep = Nil
//
//def primeInRange(endRange: Int): Stream[Int] = {
//  if(isPrime(endRange)) endRange
//else primeInRange(endRange -1)
//}

//primeInRange(10)

val num = 5
val a = 2 to num -1

def sumAll(a: Int, b: Int): Int = {
  (0 /: (a to b).sorted)(_ + _)
}

sumAll(,