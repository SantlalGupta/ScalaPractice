package essentialScala.chapter4.simpleTrait

trait shape{
  def sides:Int
  def perimeter:Double
  def area:Double
}

case class Circle(radius:Double) extends shape {

  override def sides: Int = 0

  override def perimeter: Double = 2 * Math.PI * radius

  override def area: Double = Math.PI * radius * radius
}

case class Rectangle(length: Double, breadth:Double) extends shape {

  override def sides:Int = 4
  override def perimeter: Double = 2*length + 2* breadth

  override def area: Double = length * breadth
}

case class Square(side:Double) extends shape {
  override def sides: Int = 4

  override def perimeter: Double = 4*side

  override def area: Double = side*side
}

object CircleRectSquare {
  def main(args: Array[String]): Unit = {
    val circle:shape = Circle(2.1)
    val rect : shape = Rectangle(2,3)
    val square:shape = Square(5.5)

    println("Circle, perimeter : " + circle.perimeter + "  area : " + circle.area  )
    println("Rectangle, perimeter : " + rect.perimeter + "  area : " + rect.area  )
    println("Square, perimeter : " + square.perimeter + "  area : " + square.area  )
  }
}
