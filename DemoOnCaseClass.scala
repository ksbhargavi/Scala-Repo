case class G3( x : String)


object  DemoOnCaseClass{

  def main(args: Array[String]): Unit = {

    test("G1")
    test("G2")
    test1( G3("case class"))
    test("G4")

    def test (x: String  )= x match {



      case "G1" => println(" case class not allows to use new key word to instatiate")


      case "G2" => println(" case class internally uses companion object and apply method to instantiate")


      case _ => println("Default Case Executed"   )
    }

    def test1(str: G3)=str  match {

      case G3("case class") =>println("case class can use in pattern matching")

      case _ => println()
    }
  }
}