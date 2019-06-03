trait Vehicle {
  var noOfWheels: String
  def getType(noOfWheels: String):String
  def show() = println(" Trait can have implemented methods and  can achieve multiple inheritance")

}

// due to Trait mixin concept  can allow to  extend any number of traits with a class or abstract class  and need to follow order
class Car (wheels: String= "4")extends Vehicle with BrandTrait {
 var noOfWheels: String= "4";
  def getType(noOfWheels: String): String = {
    " car  has "+ noOfWheels+ "wheels"
  }

  def apply: Car = new Car("4")
}



 object DemoOnTraits{

   def main(args: Array[String]): Unit = {

    var result   =new Car().getType("4")
    new Car().show()

     //new  BrandTrait()   "can not instantiate trait"

    println( "Brand Name  "+new Car().brandName)


     println(result)
   }
 }

