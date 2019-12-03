import scala.concurrent.Future

//test future
val oneFuture: Future[Int] = Future {
  Thread.sleep(1000)
  1
}s

def checkState() = {
  println("Before the job finishes")
  Thread.sleep(50)
}