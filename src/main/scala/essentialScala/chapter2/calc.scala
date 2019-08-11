package essentialScala.chapter2

object calc {

  def square(x:Double)=x*x
  def cube(x:Double) = x*square(x)

  def square(x:Int) = x*x
  def cube(x:Int)=x*square(x)

  def main(args: Array[String]): Unit = {
    println(square(5))
    println(cube(3))

    println(square(2.3))
    println(cube(3.2))

  }
}
