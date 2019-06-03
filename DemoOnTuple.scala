
object  DemoOnTuple{
  def main(args: Array[String]): Unit = {

    var  emp= (101,"Raj","SoftwareEngineer","Scala")

    println( " size of tuple :"+emp.productArity)

    emp.productIterator.foreach( x=> println(x))

    var  (id,name,designation,technology)= emp

    println("id :"  +id)
    println("name :"  +name)
    println("designation :"  +designation)
    println("technology :"  +technology)

    println(emp._1)


  }

}