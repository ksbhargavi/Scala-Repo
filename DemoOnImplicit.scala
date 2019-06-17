case class Dollars(amount :Double)
{
  def prettify : String = "$"+amount
}

/*object Converstion{
  implicit def DollarToDouble(d :Double):Dollars= Dollars(d)
}*/


object DemoOnImplicit {

 // import Converstion._


  /*implicit val taxRate: Double =0.80

  def withTax(dollars: Dollars)(implicit taxRate: Double): Dollars = {
    Dollars(dollars.amount *(1+ taxRate))
  }

*/

  def withTax(dollars: Dollars, taxRate: Double): Dollars = {
    Dollars(dollars.amount *(1+ taxRate))
  }


  def main(args: Array[String]): Unit = {

     val amount =withTax( Dollars(200.00),0.80).amount

    // below statment will work with implicit params
   // val amount =withTax( Dollars(200.00)).amount

    //to avoid instantiating multiple times for Case class and make user friendly

 //  withTax( 200.00,0.80)

    //String interpolation
    println(s"amount with tax $amount\n thankyou")

   var a= 1000

 //   println("amount with dollar sign "+a.prettify)
  }

}

//mark as implicit,single scope,at a time one impicit should apply, complier doesnt check when it is not required even though available