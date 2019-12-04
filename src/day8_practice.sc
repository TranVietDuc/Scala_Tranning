import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

class FutureCombinator {
  //Combinator Future
  val oneFuture = Future {
    Thread.sleep(1000)
    1
  }

  val twoFuture = Future {
    Thread.sleep(2000)
    2
  }

  val threeFuture = Future {
    Thread.sleep(2000)
    3
  }

  def sumOfParallel() = for {
    oneValue <- oneFuture
    twoValue <- twoFuture
    threeValue <- threeFuture
  } yield oneValue + twoValue + threeValue
}

val futureCombinator = new FutureCombinator
val duration = Duration(4000 , "millis")
val result = Await.result(futureCombinator.sumOfParallel(), duration )

//Test Covariant
class Animal[+T](val animal: T)

class Dog
class Puppy extends Dog

class AnimalCarer(val dog: Animal[Dog])

object ScalaCovarianceTest {
  def main(args: Array[String]): Unit ={
    val puppy = new Puppy
    val dog = new Dog

    val puppyAnimal = new Animal[Puppy](puppy)
    val dogAnimal = new Animal[Dog](dog)

    val puppyCarer = new AnimalCarer(puppyAnimal)
  }

}

//Test Contravariant
abstract class Type[-T]{
  def typeName
}

class SuperType extends Type[AnyVal]{
  override def typeName: Unit = println("Super Type")
}

class SubType extends Type[Int]{
  override def typeName: Unit = println("SubType")
}

class TypeCarer{
  def display(t: Type[Int]): Unit ={
    t.typeName
  }
}

val typeCarer = new TypeCarer
val superType = new SuperType
typeCarer.display(superType)

//Test synchronized

object Table {
  def printTable(name: String, n: Int) = {
    for (i <- 1 to 5) {
      println(name + " : " + (n*i))
        try {
          Thread.sleep(100)
        } catch {
          case (msg) => msg
        }
      }
    }
  }

class MyThread1(val name: String) extends Thread {
  override def run(): Unit ={
     Table.printTable(name, 1)
  }
}

class MyThread2(val name: String) extends Thread {
  override def run(): Unit ={
    Table.printTable(name, 10)
  }
}

val myThread1 = new MyThread1("Thread1")
val myThread2 = new MyThread2("Thread2")
val myThread11 = new MyThread1("Thread11")

myThread1.start()
myThread2.start()
myThread11.start()
Thread.sleep(20000)

