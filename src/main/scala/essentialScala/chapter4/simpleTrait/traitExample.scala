package essentialScala.chapter4.simpleTrait

trait Feeline{
  def color:String
  def sound:String
}

case class Tigers(color:String) extends Feeline{
  val sound:String = "roar"
}

case class Cat(color:String,food:String) extends Feeline{
  val sound="meow"
}

case class Lions(color:String,maneSize:Int) extends Feeline {
  val sound="roar"
}

case class Panther(color:String) extends  Feeline {
  val sound = "roar"
}

object traitExample {
  def main(args: Array[String]): Unit = {
    val tiger:Feeline = Tigers("yellow")

    val cat:Feeline = Cat("white","fish")

    val lions:Feeline = Lions("yellow",12)

    val panther:Feeline = Panther("black")
    
  }
}
