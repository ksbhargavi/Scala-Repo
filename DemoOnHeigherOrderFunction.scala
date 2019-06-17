object DemoOnHeigherOrderFunction{

  def main(args: Array[String]): Unit = {

    val salaries = Seq(20000, 70000, 40000)
    val doubleSalary = (x: Int) => x * 2
    val newSalaries = salaries.map(doubleSalary)

    println(newSalaries)

    /* we could make the function anonymous and pass it directly as an argument to map
    x is not declared as an Int . That’s because the compiler can infer the type based on the type of function map
*/
    val revisedSalaries = salaries.map(x => x * 2)

    println(revisedSalaries)

    //idiomatic way

    val updatedSalaries = salaries.map(_ * 2)

    println(updatedSalaries)
  }
}