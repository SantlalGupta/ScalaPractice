package practice.ADT
import scala.language.implicitConversions

object DS {
  sealed trait MyList[+A] //typeconstructor
  object MyList {
    type Thunk[A] = () => A

    //conversion functions
    implicit def toThunk[A](a: =>A): Thunk[A] = () => a

    //data constructor
    case object Empty extends MyList[Nothing]
    case class NotEmpty[A](head: () => A, tail:() => MyList[A]) extends MyList[A]

    def apply[A](as:Thunk[A]*):MyList[A] =
      if(as.isEmpty) Empty else NotEmpty(as.head, () => MyList(as.tail: _*))

    def head[A](list: => MyList[A]):Option[A] = list match {
      case Empty => None
      case NotEmpty(head, _) => Some(head())
    }

    def show[A](list: => MyList[A]):String = list match {
      case Empty => ""
      case NotEmpty(h,t) =>  h().toString + ", " + show(t())
    }

    def length[A](list: => MyList[A]):Int = list match {
      case Empty => 0
      case NotEmpty(_,t) => 1 + length(t())
    }

    def tail[A](list: => MyList[A]):Option[MyList[A]] = list match {
      case Empty => None
      case NotEmpty(_, tail) => Some(tail())
    }

    def take[A](num:Int, list: =>MyList[A]): MyList[A] = {
      def loop(n:Int, l: => MyList[A], acc: => Seq[() => A]):Seq[() => A] = l match {
        case _ if n == 0 => acc
        case Empty => acc
        case NotEmpty(h, t) => loop(n - 1, t(), acc :+ h)
      }
      MyList(loop( num, list, Seq.empty[() => A]):_*)
    }

  }
}
object Main {
  def main(args: Array[String]): Unit = {
    import DS._
    import MyList._

    def errorFunc:Int => Int = _ => ???

    val list = MyList(1, 2, 3, errorFunc(1),errorFunc(2),errorFunc(3))

    println(show(take(2,take(5,list))))
    /*println(tail(list))
    println(show(list))
    */

  }
}

