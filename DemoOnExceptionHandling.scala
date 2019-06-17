import scala.io.StdIn
import scala.util.{Failure, Success, Try}

object  DemoOnExceptionHandling{

  def main(args: Array[String]): Unit = {

    def divide(a : String , b:String ): Try[Int] = {
      val dividend = Try(a.toInt)
      val divisor = Try(b.toInt)
      val problem = dividend.flatMap(x => divisor.map(y => x / y))
      problem match {
        case Success(v) =>
          println("Result of " + dividend.get + "/" + divisor.get + " is: " + v)
          Success(v)
        case Failure(e) =>
          println("You must've divided by zero or entered something that's not an Int. Try again!")
          println("Info from the exception: " + e.getMessage)
          //divide(a,b)
          Failure(e)
      }

    }

    divide("a","b")
  }
}