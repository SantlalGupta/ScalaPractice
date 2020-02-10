package essentialScala.chapter4.extendedExample

sealed trait Expression{
  def eval : Double =
    this match{
      case Addition(left,right) => left.eval + right.eval
      case Subtraction(left,right) => left.eval-right.eval
      case Number(value) => value
    }
}

case class Addition(left:Expression,right:Expression) extends Expression

case class Subtraction(left:Expression,right:Expression) extends  Expression

case class Number(value:Double) extends Expression


object Calculator {
  def main(args: Array[String]): Unit = {
    val ex = Addition(Number(2),Number(3))
    println(ex.eval)
  }
}
