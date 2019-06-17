/*

import scala.util.{Failure, Success, Try,Either,Right}

object DemoOnReadFile{

  def readTextFileWithTry(filename: String): Try[List[String]] = {
    Try {
      val lines = io.Source.fromFile(filename)
   (for (line <- lines.getLines()) yield line).toList

      }

  }
  def readTextFileWithEither(filename: String): Either[List[String],String] = {

    val lines = io.Source.fromFile(filename)
    val list =(for (line <- lines.getLines()) yield line).toList

     new Right(list,"")


  }

  def readTextFileWithOption(filename: String): Option[List[String]] = {

    val lines = io.Source.fromFile(filename)
   val list= (for (line <- lines.getLines()) yield line).toList
    Some(list)
  }


  def main(args: Array[String]): Unit = {

    readTextFileWithOption("index.html") match {
      case Some(lines) =>
        lines.foreach(println)
      // case Some(lines) => Some(lines).getOrElse( new util.ArrayList[String]())
      case None => None
    }
    readTextFileWithEither("indx.html") match {
      case Right(list)=> list.foreach(println)
      case Left(list)=> if(list.isEmpty)None
    }


   /*  val lines =readTextFileWithTry("indx.html")
    lines match {
       case Success(lines)=> lines.foreach(println)
       case Failure(exception)=> None
    }*/
  }


  // https://danielwestheide.com/blog/2012/12/26/the-neophytes-guide-to-scala-part-6-error-handling-with-try.html
}*/
