


import java.io.FileNotFoundException

import scala.util.{Either, Left, Right, Try}
object DemoOnEither{

  def divideXByY(x: Int, y: Int): Either[String, Int] = {
    if (y == 0) Left("Dude, can't divide by 0")
    else Right(x / y)
  }


def readTextFileWithEither(filename: String): Either[String,List[String]] = {
try {
  val lines = io.Source.fromFile(filename)
  val list = (for (line <- lines.getLines()) yield line).toList

  Right(list)
}catch
  {
    case e : FileNotFoundException => Left("Error :"+e.getMessage)

  }
}


  def main(args: Array[String]): Unit = {
   readTextFileWithEither("index.html") match {
      case Right(list)=> list.foreach(println)
      case Left(list)=>  println(list)
    }

    divideXByY(2,0) match {
      case Right(value)=>println(value)
      case Left(value)=> println(value)
    }
  }

}