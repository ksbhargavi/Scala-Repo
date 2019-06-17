import org.scalatest.{BeforeAndAfter, FunSpec}

class DemoOnScalaTest extends FunSpec with BeforeAndAfter{
  var Obj: DemoOnTry = _

  before {
    Obj = new DemoOnTry
  }

  describe("Exception Handling") {

    it("should read file successfully") {
      assert(Obj.readFileWithTry("index.html").isSuccess)
    }

  }

  describe("Exception Handling") {

    it("should throw exceptiom") {
      assert(Obj.readFileWithTry("indx.html").isFailure)
    }

  }
  }
