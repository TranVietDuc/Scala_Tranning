import java.time.temporal.TemporalAmount
//
for( i <- 0 to 4 ) println("hello word!")

//normal class
class myClass {
  var myField : Int = 0
  def this(value: Int ) = {
    this();
    this.myField = value
  }
}
// case class
abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator : String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr,right: Expr)
val v = Var("x")
v.name
val op = BinOp("+", Number(1), v )
op.left
op.toString
op.hashCode()
op.right == Var("x")

//Pattern Matching
//constant
val boo: Boolean = 5 < 10
boo match {
  case true => 1
  case false => 2
}
//function
def matchFunction(v : Int ) = v match {
  case 1 => "one"
  case 2 => "two"
  case _ => "three"
}

matchFunction(3)
//class
trait Payment {
  def pay(amount: Double)
}
class Cash extends Payment {
  override def pay(amount: Double): Unit = println(s"Pay with cash $amount")
}
class CreditCard extends Payment{
  override def pay(amount: Double): Unit = println(s"Pay with CreditCash $amount")
  def verify() = println("Verification ....")
}
def processPayment(amount: Double, method: Payment) = method match {
  case c: Cash => c.pay(amount)
  case cc: CreditCard => cc.verify(); cc.pay(amount)
  case _ => println("Unknow methods....!")
}
val paymentA = processPayment(5.5, new Cash)
val paymentB = processPayment(6.6, new CreditCard)

//collection
val emptyLst = Nil
val oneElLst = 'a' :: Nil
val manyElLst = List("a", "b", "c")

def checkList[T](list: List[T]): String = list match {
  case Nil => "empty List"
  case list :: Nil => "one element"
  case _ => "More than one element"
}
checkList(emptyLst)
checkList(oneElLst)
checkList(manyElLst)
//recursive

val commonList = List(2,3,4,5)

def sum(list: List[Int]): Int = {
  def recursion(sum: Int, list: List[Int]): Int = list match {
    case Nil => sum
    case el :: tail => recursion(sum + el, tail)
  }
  recursion(0,list)
}
sum(commonList)

//Extractor
object firstName {
  def main(args: Array[String]): Unit = {
    println("apply method: " + apply("Steve", "Smith") )
    println("Unapply method: " + unapply("Steve Smith"))
    println("Unapply method: " + unapply("Robin"))
  }

  def apply(fname: String, lname: String): String = {
    fname  + " " + lname
  }


  def unapply(s: String): Option[(String, String)] = {
    val pts = s split " "
    if(pts.length == 2) {
      Some(pts(0), pts(1))
    } else {
      None
    }
  }
}

firstName.main(Array("1"))

// patternMatching + Extractor
case class Address(city: String, state: String)
case class Student(name: String, address: Seq[Address])

object City{
  def unapply(s: Student): Option[Seq[String]] =
    Some(
      for (c <- s.address)
        yield  c.state
  )
}

class StringSeqContains(value: String){
  def unapply(in: Seq[String]): Boolean = in contains value
}

object PatternMatch{
  def main(args: Array[String]): Unit = {
    val stud = List(Student("Harris", List(Address("LosAngeles", "California"))),
      Student("Reena", List(Address("Houston", "Texas"))),
      Student("Rob", List(Address("Dallas", "Texas"))),
      Student("Chris", List(Address("Jacksonville", "Florida"))))

    val Texas = new StringSeqContains("Texas")
    val students = stud collect {
      case student @ City(Texas()) => student.name
    }
    println(students
    )
  }
}
PatternMatch.main( Array()
)

object EMail {
  def apply(user: String, domain: String) = user + "@" + domain

  def unapply(str: String): Option[(String, String)]= {
    val parts = str split("@")
    if (parts.length == 2) Some(parts(0), parts(2))
    else None
  }
}

val apply = EMail("duc", "gmail")

apply match {
  case EMail("duc", "gmail") =>
  case _ => None

}