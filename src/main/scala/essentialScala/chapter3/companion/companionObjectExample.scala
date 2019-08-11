package essentialScala.chapter3.companion

// Companion object is used to provide addition constructor.
// Used to implement static methods like java
// Companion object have same name as class name. This doesnot conflict naming because scala has 1. namespace for value and 2. namespace for type
// companion object must be defined in same file as with associated class
// companion object is not object of the class
class companionObjectExample(val second:Long)

object companionObjectExample {
  def apply(hour:Int,minute:Int,second:Int): companionObjectExample =
    new companionObjectExample(hour*60*60+minute*60+second)

  def apply(minute:Int,second: Int): companionObjectExample =
    new companionObjectExample(minute*60 + second)

  def apply(second: Long): companionObjectExample = new companionObjectExample(second)
}

object companionObjectExampleMain {
  def main(args: Array[String]): Unit = {

    println(companionObjectExample(1,1,1).second)
    println(companionObjectExample(1,1).second)
    println(companionObjectExample(1).second)

  }
}
