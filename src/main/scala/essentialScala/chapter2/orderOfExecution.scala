package essentialScala.chapter2

object argh {
  def a = {
    println("a")
    1
  }

  val b = {
    println("b")
    a + 2
  }

  def c = {
    println("c")
    a
  }
}

object orderOfExecution {
  def main(args: Array[String]): Unit = {
    // when argh object is called it first evaluates its's field
  // so while evaluating it will first assign value to variable b, which will call a and this inititalization will also print a too.
    argh
println("hello")
    argh.c+argh.b+argh.a

    // variable once intitialized will keep its value and does  not call print statement
    // this means object are singleton. It is created and intialized only once
  }
}
