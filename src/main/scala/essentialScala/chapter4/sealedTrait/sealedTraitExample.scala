package essentialScala.chapter4.sealedTrait

sealed trait shapeSeal{
  def sides:Int
  def perimiter:Double
}

final case class RectangleSeal (width:Double,height:Double) extends  shapeSeal{
  override def sides: Int = ???

  override def perimiter: Double = ???
}


final case class SquareSeal(side:Double) extends  shapeSeal {
  override def sides: Int = ???

  override def perimiter: Double = ???
}

object sealedTraitExample {

  def apply(v:shapeSeal): String = v match {
    case RectangleSeal(width,height) => s"This is rectangle, width : ${width}, height: ${height} "
    case SquareSeal(side) => s"This is square side : ${side}"
  }

  def main(args: Array[String]): Unit = {
    println(sealedTraitExample(RectangleSeal(2,3)))
      println(sealedTraitExample(SquareSeal(2)))

  }
}
