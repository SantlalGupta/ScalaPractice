package essentialScala.chapter4.tailRecursion

import scala.annotation.tailrec

sealed trait IntList

final case object End extends IntList

final case class Pair(head:Int,tail:IntList) extends IntList {

  @tailrec
  def calculateLength(tail:IntList, l:Int = 0 ):Int = {
    tail match {
      case End => l
      case Pair(h,list) => calculateLength(list,l + 1)
    }
  }
  def length : Int = {
    calculateLength(this,0)
  }
}
object Length {
  def main(args: Array[String]): Unit = {
    val example = Pair(3,Pair(2,Pair(1,End)))
    println(example.length)
  }
}
