package practice

object FunctionsVsMethod {
  val sq=(x:Int)=>{
    println("value function x=> " + x)
    x*x
  }

  def square(p:Int) = {
    println("Method p : " + p)
    p*p
  }
  def main(args: Array[String]): Unit = {

    val list = List.range(1,3)
    list.map(x=> println(sq(x)))

    list.map(x=>println(square(x)))
  }
}
