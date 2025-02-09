```scala
import scala.concurrent.{ExecutionContext, ExecutionContextExecutor, Future}
import scala.concurrent.duration._
import scala.util.{Failure, Success}

class MyClass(ec: ExecutionContextExecutor) {
  def myMethod(i: Int): Future[Int] = Future { i * 2 }(ec)
}

object Main extends App{
  //Creating an execution context with a thread pool size of 10
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.fromExecutor(
    java.util.concurrent.Executors.newFixedThreadPool(10)
  )

  val myClass = new MyClass(ec)
  val futures = (1 to 100).map{i => myClass.myMethod(i)}

  Future.sequence(futures).onComplete {
    case Success(values) => {
      println(s"Results: $values")
      ec.shutdown()
    }
    case Failure(exception) => {
      println(s"Failure: $exception")
      ec.shutdown()
    }
  }

  Thread.sleep(2000) //Keep the main thread alive so that the execution context can finish
}
```