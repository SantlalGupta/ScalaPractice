import java.io.FileReader
object test {
  def main(args: Array[String]) {
   println(result(2))
    println(result(0))
  }

  def result(den:Int):Int = {
    var res=0
    try{
       res = 10/den
    } catch {
     // case a:ArithmeticException => println("division by o")
      case b:IndexOutOfBoundsException => println("index")
    }
    res
  }

}