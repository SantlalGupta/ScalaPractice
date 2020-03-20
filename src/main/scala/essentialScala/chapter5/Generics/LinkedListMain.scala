package essentialScala.chapter5.Generics

trait Result[A]
case class Success[A](value:A) extends Result[A]
case class Failure[A](msg:String) extends Result[A]

sealed trait LinkedList[T]{
  def length:Int= this match {
    case PairL(hd,ls)=>1+ls.length
    case EndL()=>0
  }

  def contains(v:T):Boolean =  this match{
    case PairL(hd,ls)=> if(hd==v) true else ls.contains(v)
    case EndL()=> false
  }

  def apply(index:Int): Result[T] = this match{
    case PairL(hd,tl)=> if(index==0) Success(hd) else tl(index-1)
    case EndL()=> Failure("Index out of bound")
  }
}

final case class EndL[T]() extends LinkedList[T]

final case class PairL[T](head: T, tail:LinkedList[T]) extends LinkedList[T]{}

object IntListMain {
  def main(args: Array[String]): Unit = {

    val example = PairL(2,PairL(4,PairL(6,EndL())))
    println(example.length)

    println(example.contains(4))
    println(EndL().contains(0))
    println(example(0))
    println(example(4))


  }
}
