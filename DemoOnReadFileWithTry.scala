import scala.util.{Failure, Success, Try}



class DemoOnTry {
  def readFileWithTry(filename: String): Try[List[String]] = {
    Try {
      val lines = io.Source.fromFile(filename)
      (for (line <- lines.getLines()) yield line).toList

    }

  }
}

object DemoOnReadFileWithTry {



  def main(args: Array[String]): Unit = {
  val obj: DemoOnTry=   new DemoOnTry()
    val lines =obj.readFileWithTry("indx.html")
    lines match {
      case Success(lines)=> lines.foreach(println)
      case Failure(e)=> None
     //   println(e.getMessage)
    }
  }
}
