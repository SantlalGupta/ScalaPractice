package essentialScala.chapter3.patternMatching

case class Cat(val name:String,val color:String, val food:String)

object ChipShop{
  def willServe(cat:Cat):Boolean={

    cat match {
      case Cat(_,_,"Chips")=> true
      case Cat(_,_,_) => false
    }
  }
}

object Cat {
  def main(args: Array[String]): Unit = {

    val os =  Cat( "Oswald", "Black","Milk")
    val hend = Cat("Henderson","Ginger","Chips")
    val quen = Cat("Quen","Tabby and white" , "Curry")

    println("Serving Chips: " + ChipShop.willServe(os))
    println("Serving Chips: " + ChipShop.willServe(hend))
  }
}
