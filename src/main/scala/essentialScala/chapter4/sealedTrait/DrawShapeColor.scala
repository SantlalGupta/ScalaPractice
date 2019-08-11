package essentialScala.chapter4.sealedTrait

sealed trait Color {
  def red:Double
  def green:Double
  def blue:Double

  def isLight:Boolean = (red+green+blue)/3.0 > 0.5
  def isDark:Boolean = !isLight
}

object Red extends Color{
  val red = 1.0
  val green = 0.0
  val blue = 0.0
}

object Yellow extends Color {
  val red: Double = 1.0
  val green: Double = 1.0
  val blue: Double = 0.0
}

object Pink extends Color{
  val red: Double = 1.0
  val green: Double = 1.0
  val blue: Double = 1.0
}

final case class CustomColor(red:Double,green:Double,blue:Double) extends Color{
}

sealed trait ShapeColor {
  def sides:Int
  def perimiter:Double
  def area:Double
  def color:Color
}

case class Circle(radius:Double,color:Color) extends ShapeColor {
  val sides: Int = 1
  val perimiter: Double = 2*Math.PI*radius
  val area: Double = Math.PI*radius*radius
}

sealed  trait Rectangular extends ShapeColor {
  def width:Double
  def height:Double

  val sides=4
  val perimiter:Double=2*width + 2*height
  val area:Double=width*height
}

case class Square(side:Double,color:Color) extends Rectangular{
  val width = side
  val height = side
}

case class Rectangle(width:Double,height:Double,color:Color) extends Rectangular

object DrawShapeColor {

  def apply(s:ShapeColor):String = s match{
    case Circle(radius,color) => s"The ${DrawShapeColor(color)} circle of radius ${radius}cm"
    case Rectangle(width,height,color)=> s"The ${DrawShapeColor(color)} rectangle of width ${width}cm and height ${height}cm"
    case Square(side,color)=> s"The ${DrawShapeColor(color)} Square of side ${side}cm"
  }

  def apply(c:Color):String = c match {
    case Red => "Red"
    case Yellow => "Yellow"
    case Pink => "Pink"
    case c => if(c.isLight) "Light" else  "Dark"
  }

  def main(args: Array[String]): Unit = {
    println(DrawShapeColor(Circle(4.5, Red)))
    println(DrawShapeColor(Rectangle(1,2,Yellow)))
    println(DrawShapeColor(Square(3,CustomColor(0.2,0.4,0.7))))

  }
}
