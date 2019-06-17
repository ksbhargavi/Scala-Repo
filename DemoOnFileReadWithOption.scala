import java.io.FileNotFoundException

object DemoOnFileReadWithOption{

  def readFileWithOption(filename: String): Option[List[String]] = {

    try {
      val lines = io.Source.fromFile(filename)
      val list = (for (line <- lines.getLines()) yield line).toList
      Some(list)
    }
    catch {
      case e: FileNotFoundException=> None
    }
  }

  def main(args: Array[String]): Unit = {

    readFileWithOption("indx.html") match {
      case Some(lines) =>
        lines.foreach(println)
      // case Some(lines) => Some(lines).getOrElse( new util.ArrayList[String]())
      case None => None
    }
  }
}