package essentialScala.chapter4.tailRecursion

sealed trait IntListP {
 def product : Int =
   this match {
     case EndP => 1
     case PairP(h,tl)=>h*tl.product
   }
}
case object EndP extends  IntListP
final case class PairP(head:Int,tail:IntListP) extends IntListP

object product {
  def main(args: Array[String]): Unit = {
    val ex = PairP(3,PairP(2,PairP(1,EndP)))
    println(ex.product)
  }
}
