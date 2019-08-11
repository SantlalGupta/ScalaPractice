package essentialScala.chapter3.constructor

class ObjectAsFunction(val count:Int) {

  def apply(adder:AdderC): ObjectAsFunction =
    // new ObjectAsFunction(adder.apply(count)) // or
   new ObjectAsFunction(adder(count))
  // Here object adder acts as function because it have apply function
}

class AdderC(amount:Int) {
  def apply(in:Int) = in + amount
}


object ObjectAsFunctionMain {
  def main(args: Array[String]): Unit = {

    val adder:AdderC = new AdderC(5)
   // println(new ObjectAsFunction(20).apply(adder).count)
    // OR
    println(new ObjectAsFunction(20)(adder).count)
  }
}