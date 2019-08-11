package essentialScala.chapter2

object valTest {

  val myVal:Int = {
    println("called while definition")
    55
  }

  def main(args: Array[String]): Unit = {
    println("In main")
    println(myVal)
  }
}
