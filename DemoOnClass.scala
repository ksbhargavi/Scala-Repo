
class DemoOnClass{

  val id: String ="101";

  def show = println(" id  :" + id )



}


class ClassWithPrimaryConstructor ( val name : String ){


  def show = {println( " Name  :" + name)}

  }




object MainObject{

  def main(args: Array[String]): Unit = {

    val   obj2 = new ClassWithPrimaryConstructor("Sandhya");
    obj2.show



    val  obj1 = new DemoOnClass()
    obj1.show
   // obj1.id="1012"; // check immutability
   println(" access parameters directly : "+obj1.id)


  }
}