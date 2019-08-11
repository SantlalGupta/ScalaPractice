package essentialScala.chapter4.sealedTrait

sealed trait DivisionResult

case class Finite(result:Int) extends DivisionResult
case object Infinite extends DivisionResult

object divide {
  def apply(num:Int,den:Int): DivisionResult = if(den==0) Infinite else Finite(num/den)

  def divisionRs(rs:DivisionResult):String = rs match {
    case Finite(r) => s"Division is Finite, result ${r}"
    case Infinite => "Division result is infinite"
  }

  def main(args: Array[String]): Unit = {
    println(divisionRs(divide(4,2)))
    println(divisionRs(divide(4,0)))

  }
}
