package essentialScala.chapter4.tailRecursion

sealed trait IntBaseList {
  def length : Int =
    this match {
      case EndL =>0
      case PairL(h,tl)=> 1 + tl.length
    }
}

case object EndL extends  IntBaseList

final case class PairL(head:Int,tail:IntBaseList) extends IntBaseList

object RecursionInBaseTrait {
  def main(args: Array[String]): Unit = {
    val ex = PairL(3,PairL(2,PairL(1,EndL)))
    println(ex.length)
  }
}