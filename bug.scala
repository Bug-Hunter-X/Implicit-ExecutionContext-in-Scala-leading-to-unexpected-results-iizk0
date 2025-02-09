```scala
import scala.concurrent.{ExecutionContext, Future}

class MyClass(implicit ec: ExecutionContext) {
  def myMethod(i: Int): Future[Int] = Future { i * 2 }
}

//Example of how this class would be used. 
object Main extends App{
  implicit val ec = scala.concurrent.ExecutionContext.global
  val myClass = new MyClass()
  myClass.myMethod(2).onComplete{
    case scala.util.Success(value) => println(value)
    case scala.util.Failure(exception) => println(exception)
  }
  Thread.sleep(1000)
}
```