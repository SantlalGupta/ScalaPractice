package essentialScala.chapter4.tailRecursion

sealed  trait IntListD{
  def double:IntListD =
    this match {
      case EndD => EndD
      case PairD(h,tl) => PairD(h*2,tl.double)

    }
}
case object EndD extends IntListD

final case class PairD(head:Int,tail:IntListD) extends IntListD

object Double {
  def main(args: Array[String]): Unit = {
    val ex = PairD(2,PairD(1,EndD))
    println(ex.double)

  }
}
