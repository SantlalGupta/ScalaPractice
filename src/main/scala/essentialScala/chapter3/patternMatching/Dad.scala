package essentialScala.chapter3.patternMatching

case class Director(fname:String,lname:String,age:Int)

case class Film(val name:String, val yearOfRelease:Int, val imdbRating:Double, val director: Director)

object Dad {
def rate(film:Film):Double = {

  film.director match {
    case Director("Clint","Eastwood",_) => 10.0
    case Director("John","McTiernan",_) => 7.0
    case Director(_,_,_) => 3.0
  }
}

  def main(args: Array[String]): Unit = {
    val clint = Director("Clint","Eastwood",56)
    val john = Director("John","McTiernan",34)
    val mac= Director("Mac","John",34)

    val clintFilm = Film("Clint",2012,12,clint)
    val johnFilm = Film("John",2011,22,john)
    val macFilm = Film("Mac",2010,11,mac)

    println("Clint rate : " + rate(clintFilm))
    println("john rate : " + rate(johnFilm))
    println("macFilm : " + rate(macFilm))



  }
}
