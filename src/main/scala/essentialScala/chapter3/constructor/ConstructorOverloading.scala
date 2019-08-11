package essentialScala.chapter3.constructor

class ConstructorOverloading(fname:String,lname:String,age:Int) {

  println("primary constructor called")
  def this(){
    this(null,null,0)
    println("Zero argument auxiliary constructor")
  }

  def this(fname:String){
    this(fname,null,0)
    println("One argument auxiliary constructor")
  }

  def this(fname:String, lname:String){
    this(fname,lname,0)
    println("Two argument auxiliary constructor")
  }
}


object ConstructorOverloading {
  def main(args: Array[String]): Unit = {
    val co1 = new ConstructorOverloading()


    val co11 = new ConstructorOverloading("s")


    val co12 = new ConstructorOverloading("s","g")


    val co13 = new ConstructorOverloading("s","g",32)

  }
}