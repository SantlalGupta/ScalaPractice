package practice.ADT


sealed trait myList[+A] {
  def head[A](list: myList[A]): Option[A] = {
    list match {
      case Empty => None
      case NonEmpty(head, _) => Some(head)
    }
  }

  def tail[A](list:myList[A]): Option[myList[A]] = {
    list match {
      case Empty => None
      case NonEmpty(_,tail)=> Some(tail)
    }
  }
}

case object Empty extends myList[Nothing]

case class NonEmpty[A](head: A, tail: myList[A]) extends myList[A]

object CustomListImplementation extends App {

  // list can be empty, here the issue is mylist is Int type but Empty have Nothing type
  // this can be resolved by making myList[+A]
  // that's is covarient, informing that type can Nothing also
  val myIntList: myList[Int] = Empty

  val intList:myList[Int] = NonEmpty(3, NonEmpty(2, NonEmpty(1, Empty)))

  println(intList.head(intList))
  println(intList.tail(intList))
 // println(intList.tail)

  val intList1= NonEmpty(3, NonEmpty(2, NonEmpty(1, Empty)))
  println(intList1.tail)
    println(myIntList.head(myIntList))  // so here no error
  // will raise an error as
  // Exception in thread "main" java.util.NoSuchElementException: head of empty list
  //println(List().head)

  // So instead of head we should use `headOption which give None
  println(List().headOption)

  // Scala list is EAGER, It is evaluating each element even we are looking for only head
  // Giving error as
  // Exception in thread "main" scala.NotImplementedError: an implementation is missing
  // So this should not happen, we need our list as LAZY as HASKELL so that it not evaluate the element which is not required
  println(List(1,???,???).head)
}
