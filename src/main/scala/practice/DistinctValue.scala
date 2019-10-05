package practice

import scala.io.Source

object DistinctValue {
  def main(args: Array[String]): Unit = {
   val lines:Array[String]=Source.fromFile("testData/input/Student").getLines().toArray

    var stud:Map[String,String]=Map()

    for(i <- 0 to lines.length -1) {
        val line = lines(i).split(",")
      stud= stud + (line(0)->line(1))
      }

    val keys = stud.keysIterator.toArray
    keys.foreach(key=> println(key + " " + stud(key)))

  }
}
