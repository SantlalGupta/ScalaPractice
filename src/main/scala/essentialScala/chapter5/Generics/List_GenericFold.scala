package essentialScala.chapter5.Generics

sealed trait G_Fold {
  def foldG[A](end:A,f:(Int,A)=>A): A = {
    this match {
      case EndG => end
      case PairG(hd,tl)=> f(hd,tl.foldG(end,f))
    }
  }

  def length:Int = foldG[Int](0,(_,tl)=>1+tl)
  def sum:Int = foldG[Int](0,(hd,tl)=>hd+tl)
  def product:Int= foldG[Int](1,(hd,tl)=> hd*tl)
  def double:G_Fold = foldG[G_Fold](EndG,(hd,tl)=> PairG(hd*2,tl))
  }

case object EndG extends G_Fold
case class PairG(head:Int,tail:G_Fold) extends G_Fold

object List_GenericFold {
  def main(args: Array[String]): Unit = {
    val list:G_Fold=PairG(3,PairG(2,PairG(1,EndG)))
    println(list.length)
    println(list.sum)
    println(list.product)
    println(list.double)

  }
}
