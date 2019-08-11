package essentialScala.chapter2

object Person{
  val firstName="Santlal"
  val secondName="Gupta"
}


object alien{

  def greet(p:Person.type) = {
    "greeetng Mr " + p.firstName + " " + p.secondName
  }
}

object greetingHuman {
  def main(args: Array[String]): Unit = {

    println(alien.greet(Person))
  }

}
