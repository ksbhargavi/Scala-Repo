import scala.collection.immutable.HashMap

object  Employee {
  private  val userName : String ="abc"

  private val password : String ="1234"

  def apply: Employee = new Employee()

}


class Employee{

  private val credentials= HashMap("userName" -> Employee.userName, "password" -> Employee.password)
  println( "credentials :" + credentials.get("userName"))

}


object  DemoOnCompanoinObject{

  def main(args: Array[String]): Unit = {
    new Employee();

  }
}