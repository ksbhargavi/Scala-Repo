import org.scalatest.{FunSpec, GivenWhenThen}

class DemoOnGivenWhenThen extends FunSpec with GivenWhenThen{

  var obj:DemoOnTry=_

  describe(" exception handling"){

    it ("should allow the addition of toppings") {

      Given("creating context")
      obj = new DemoOnTry()

      When("Read File")
      val lines=obj.readFileWithTry("index.html")

      Then("read file successfully")
       val  stringList: List[String]   =lines.get


      And("the topping should be what was added")
           assert( !stringList.isEmpty)
    }

  }


}
