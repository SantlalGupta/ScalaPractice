package essentialScala.chapter2

object valVsLazy {
  val myVal:Int = {
    println("Called at time of defination")   // 1
    88
  }

  lazy val myLazy:Int={
    println("called at time of first call") // 4
    99
  }

  def main(args: Array[String]): Unit = {
    println("I am in main")         // 2
    println("my Val : " + myVal)    // 3
    println("my lazy Val : " + myLazy) // 5
    println ("call again both val and lazy : " + myVal + " " + myLazy)  // 6. output
  }
}

/* output :
Called at time of defination
I am in main
my Val : 88
called at time of first call
my lazy Val : 99
call again both val and lazy : 88 99
 */