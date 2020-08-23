package essentialScala.chapter5.Generics

trait IntList_Fold {

  def fold(end:Int,f:(Int,Int)=>Int):Int = this match {
    case End => end
    case PairIF(hd,tl)=>f(hd,tl.fold(end,f))
  }

  def lengthF : Int = fold(0,(hd,tl)=>1+tl)
  def sumF:Int = fold(0,(hd,tl)=>hd+tl)
  def productF:Int = fold(1,(hd,tl)=>hd*tl)
  def subF:Int = fold(0,(hd,tl)=>hd-tl)

  def length: Int = this match {
    case End => 0
    case PairIF(hd, tl) => 1 + tl.length
  }

  def sum: Int = this match {
    case End => 0
    case PairIF(hd, tl) => hd + tl.sum
  }
}

case object End extends IntList_Fold

case class PairIF(hd: Int, tl: IntList_Fold) extends IntList_Fold

object IntList_Fold {

  def main(args: Array[String]): Unit = {
    val pair = PairIF(2, PairIF(4, End))
    println(pair.subF)
    println(pair.lengthF)
    println(pair.length)
    println(pair.sum)
  }
}
