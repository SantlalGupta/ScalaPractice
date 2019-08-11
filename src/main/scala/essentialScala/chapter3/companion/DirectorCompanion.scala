package essentialScala.chapter3.companion



class DirectorCompanion (val firstName:String, val lastName:String, val yearOfBirth:Int) {

  def name:String= firstName + " " + lastName
}

class FilmCompanion (val name:String, val yearOfRelease:Int, val imdbRating:Double, val director: DirectorCompanion) {

  def directorsAge: Int = yearOfRelease - director.yearOfBirth

  def isDirectedBy(direct: DirectorCompanion): Boolean = direct.name == director.name


  def copy(name:String=this.name, yearOfRelease:Int=this.yearOfRelease,  imdbRating:Double=this.imdbRating
           , director: DirectorCompanion=this.director):FilmCompanion =
    new FilmCompanion(name,yearOfRelease,imdbRating,director)
}

object DirectorCompanion{
  
  def apply( firstName: String,lastName: String,yearOfBirth: Int): DirectorCompanion =
    new DirectorCompanion(firstName,lastName,yearOfBirth)

  def oldest(director1:DirectorCompanion, director2:DirectorCompanion):DirectorCompanion = {
    if(director1.yearOfBirth>director2.yearOfBirth) director2
    else director1
  }
}

object FilmCompanion {
  def apply(name: String,yearOfRelease: Int,imdbRating: Double,director: DirectorCompanion): FilmCompanion =
    new FilmCompanion(name,yearOfRelease,imdbRating,director)

  def highestRating(film1:FilmCompanion,film2:FilmCompanion):Double={
    if(film1.imdbRating>film2.imdbRating) film1.imdbRating
    else film2.imdbRating
  }

  def oldestDirectorAtTheTime(film1:FilmCompanion, film2:FilmCompanion) : DirectorCompanion = {
    DirectorCompanion.oldest(film1.director,film2.director)
  }
}


object MainDirectorCompanion {
  def main(args: Array[String]): Unit = {
    val rahagir= FilmCompanion("rahagir", 2012,2.3,DirectorCompanion("raj","kumar",1987))

    val saregama= FilmCompanion("saregama",2013,3.2,DirectorCompanion("ram","dular",1988))

    println("highest rating film: " + FilmCompanion.highestRating(rahagir,saregama))
    println("oldest director : " + FilmCompanion.oldestDirectorAtTheTime(rahagir,saregama).name)
  }
}
