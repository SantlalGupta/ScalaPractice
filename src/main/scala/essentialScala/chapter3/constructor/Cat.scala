package essentialScala.chapter3.constructor

class Cat(val name:String,val color:String, val food:String)

object ChipShop{
  def willServe(cat:Cat):Boolean={
    if(cat.food == "Chips"){
      true
    } else {
      false
    }
  }
}

object Cat {
  def main(args: Array[String]): Unit = {

    val os = new Cat( "Oswald", "Black","Milk")
    val hend = new Cat("Henderson","Ginger","Chips")
    val quen = new Cat("Quen","Tabby and white" , "Curry")

    println("Serving Chips: " + ChipShop.willServe(os))
    println("Serving Chips: " + ChipShop.willServe(hend))
  }
}
