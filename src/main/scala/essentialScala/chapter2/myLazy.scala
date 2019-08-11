package essentialScala.chapter2

object myLazy {
  lazy val myVal:Int = {
    println("called while use")
    55
  }

  def main(args: Array[String]): Unit = {
    println("In main")
    println(myVal)
  }
}
