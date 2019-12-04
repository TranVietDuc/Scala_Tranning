
import java.util.concurrent.FutureTask

import org.scalatest.FunSpec
import org.scalatest.matchers.Matchers

import scala.actors.threadpool.Executors
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future, Promise}
import scala.util.{Failure, Success}


//test future
class PromisingFutures {

  import scala.concurrent.ExecutionContext.Implicits.global

  val oneFuture: Future[Int]= Future {
    Thread.sleep(1000)
    1
  }

  def checkState() = {
    println("Before the job finishes")
    Thread.sleep(500)
    println(s"Completed: ${oneFuture.isCompleted}, Value: ${oneFuture.value}")
    println("After the job finishes")
    Thread.sleep(1100)
    println(s"Completed: ${oneFuture.isCompleted}, Value: ${oneFuture.value}")
  }

  case class SomeComputationException(msg: String) extends Exception(msg)
  //Lay ve gia tri cua future
  val oneDangerousFuture=Future{
    Thread.sleep(2000)
    throw new SomeComputationException("Fail in dark side!")
  }

  //test CallBack
  def printFuture[T](future: Future[T]) = future.onComplete {
    case Success(result) => println(s"Success $result")
    case Failure(exception) => println(s"Failure $exception")
  }

  def main(args: Array[String]): Unit = {
    val promisingFutures = new PromisingFutures()
    promisingFutures.printFuture(promisingFutures.oneFuture)
    promisingFutures.printFuture(promisingFutures.oneDangerousFuture)

    synchronized(wait(3000))
  }

}

val promisingFutures = new PromisingFutures()
promisingFutures.main(Array())
//
//// Test case Lay ve gia tri cua future
//
//class PromisingFutureTest extends FunSpec with ClassicMatchers{
//  describe("A Promising Future"){
//    it("should hold a Int value if the Await.return is called after the Future completes"){
//      val promisingFutures = new PromisingFutures()
//      val oneFuture = promisingFutures.oneFuture
//      val duration1 = Duration(2, "millis")
//      val initValue = Await.result(oneFuture, duration1)
//    }
//  }
//
//}

//Test Promise
class PromiseInternals {

  import scala.concurrent.ExecutionContext.Implicits.global

  def aCompletedPromiseUsingSuccess(num: Int): Future[Int] = {
    val promise = Promise[Int]()
    promise.complete(Success(num))
    promise.complete(Failure(new RuntimeException("Evil Exception")))
    promise.future
  }

  def assertValueUsingOnComplete(future: Future[Int], expValue: Int) = {
    future.onComplete {
      case Success(result) => {
        println(s"Success: result: $result, expected: $expValue")
      }
      case Failure(msg) => println(s"Fail: $msg")
    }
  }

  def main(args: Array[String]): Unit = {

    assertValueUsingOnComplete(aCompletedPromiseUsingSuccess(5), 6)
    synchronized(wait(1000))
  }
}

val promiseInternals = new PromiseInternals()
promiseInternals.main(Array())

//Combinator
class FutureCombinators{
  import scala.concurrent.ExecutionContext.Implicits.global
  def sumOfThreeNumbersSequentialMap(): Future[Int] = {
    Future {
      Thread.sleep(1000)
      1
    }.flatMap{oneValue =>
    Future {
      Thread.sleep(2000)
      2
    }.flatMap{ twoValue =>
      Future {
        Thread.sleep(3000)
        3
      }.map { thirdValue => oneValue + twoValue + thirdValue}
    }
    }
  }
}

//Test Executor
def primesReversion(a: Int, b: Int): Int = {
   def isPrime(a: Int): Boolean = {
     (a > 1 && ((2 until a-1 ).filter(x => a % x == 0).isEmpty))
   }
  2
}

def isPrime(a: Int): Boolean = {
  (a > 1 && ((2 until a-1 ).filter(x => a % x == 0).isEmpty))
}

val x = isPrime(2)