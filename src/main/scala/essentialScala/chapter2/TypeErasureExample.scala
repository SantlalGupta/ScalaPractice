package essentialScala.chapter2

import scala.reflect.ClassTag
import scala.reflect.runtime.universe._


/**
 * We want to extract data of specific type request by user
 * method takes list of a mixed objects and extract only object of certain type
 */
object Extractor {
  // Here generic type erased by compiler after compilation so T will be erased
  // And T will be represented as Object
  // As object is supper class of all type so it cannot differentiate between string,list,Int
  def extract[T](list: List[Any]) = {
    list.flatMap {
      case ele: T => Some(ele)
      case _ => None
    }
  }

  /**
   * implicit value of type ClassTag, compiler will create this value for us
   * here implicit value value of type u.ClassTag[T] is required, the compilier will make one up on demand
   */

  def extract_usingClassTag[T](list:List[Any])(implicit tag:ClassTag[T]) ={
    list.flatMap({
      case elem:T => Some(elem)  // this will be translated to   case (elem @ tag(_:T)) => some(elem)
      case _ => None
    })
  }

  def extract_usingTypeTag[T](thing: T)(implicit tag:TypeTag[T]) = {
  //  OR  def extract_usingTypeTag[T:TypeTag](thing: T) = {
    thing match {
      case elem if typeOf[T] =:= typeOf[List[Int]] => "Int" // this will be translated to   case (elem @ tag(_:T)) => some(elem)
      case el if typeOf[T] =:= typeOf[List[String]] => "String"
      case _ => "Unknown value"
    }
  }

  /*def filterType[T:TypeTag](value:T)={
    value match {
      case s:String => Some(s)
      case i:Int=> Some(i)
      case b:Boolean=> Some(b)
    }
  }*/

}

object TypeErasureExample {
  def main(args: Array[String]): Unit = {

    val list:List[Any]=List(1,"string1",List(),"String2")
    val result=Extractor.extract[String](list)
    println(result)  // output List(1, string1, List(), String2)

    val result_classTag = Extractor.extract_usingClassTag[String](list)
    println(result_classTag) // output List(string1, String2)

    val listOfList:List[List[Any]]=List(List("a","b"),List(1,2))
    val result_ClassTag2=Extractor.extract_usingClassTag[List[Int]](listOfList)
    println(result_ClassTag2) // List(List(a, b), List(1, 2))   because classTag can not differentiate at higher level
    // so not able to differentiate between List[String] or List[Int]
    // It can differentiate between Seq or List but not between Seq[String] or Seq[Int]

    println(Extractor.extract_usingTypeTag(List("a","b"))) // output String
    println(Extractor.extract_usingTypeTag(List(1,2)))   // Int

/*    val listMix = List("a",true,1)
    println(listMix.map(x=> Extractor.filterType(x)))*/
  }

}
