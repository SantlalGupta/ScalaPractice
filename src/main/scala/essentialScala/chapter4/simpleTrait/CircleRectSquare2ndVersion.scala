package essentialScala.chapter4.simpleTrait

trait shape2nd {
  def sides:Int
  def perimeter:Double
  def area:Double
}

trait Rectangular extends shape2nd {
  def width:Double
  def height:Double
  val sides=4

  override def perimeter: Double = 2*width + 2*height

  override def area: Double = width*height
}

case class Square2nd(side:Double) extends Rectangular {
  override def width: Double = side
  override def height: Double = side
}

case class Rectangle2nd(width:Double,height:Double) extends Rectangular{

}
case class Circle2nd(radius:Double) extends shape2nd {

  override def sides: Int = 0

  override def perimeter: Double = 2 * Math.PI * radius

  override def area: Double = Math.PI * radius * radius
}



object CircleRectSquare2ndVersion {
  def main(args: Array[String]): Unit = {
    val circle:shape2nd = Circle2nd(2.1)
    val rect : shape2nd = Rectangle2nd(2,3)
    val square:shape2nd = Square2nd(5.5)

    println("Circle, perimeter : " + circle.perimeter + "  area : " + circle.area  )
    println("Rectangle, perimeter : " + rect.perimeter + "  area : " + rect.area  )
    println("Square, perimeter : " + square.perimeter + "  area : " + square.area  )

  }
}
