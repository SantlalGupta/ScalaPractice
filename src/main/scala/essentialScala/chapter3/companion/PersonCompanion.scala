package essentialScala.chapter3.companion

class PersonCompanion(val firstName:String, val lastName:String)

object PersonCompanion {

  def apply(name:String): PersonCompanion = {
    val nameAr = name.split(" ")
    new PersonCompanion(nameAr(0),nameAr(1))
  }
}

object PersonMain {
  def main(args: Array[String]): Unit = {
    println(PersonCompanion("Santlal Gupta").firstName)
    println(PersonCompanion("Santlal Gupta").lastName)
  }
}
