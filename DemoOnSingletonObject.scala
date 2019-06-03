object SingletonObject{

  def add ( a : Int , b : Int): Int ={
    a+b
  }
}

object DemoOnSingletonObject{

  def main(args: Array[String]): Unit = {


   var result= SingletonObject.add(3,4);
    //var obj= new SingletonObject() not allow to create object

    println(result)

    println( SingletonObject.toString())

  }

}
