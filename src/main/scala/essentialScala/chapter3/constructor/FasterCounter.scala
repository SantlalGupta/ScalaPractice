package essentialScala.chapter3.constructor

class FasterCounter(val count:Int) {

  def inc:FasterCounter=inc() // () means calling inc method which take single parameter having default value

  def dec:FasterCounter=dec()

  def inc(amount:Int=1):FasterCounter = new FasterCounter(count + amount)

  def dec(amount:Int=1):FasterCounter = new FasterCounter(count - amount)

 // def inc(a:Int):FasterCounter = new FasterCounter(count + a)

  def adjust(adder:Adder) : FasterCounter =
    new FasterCounter(adder.add(count))
}

class Adder(amount: Int) {
  def add(in: Int) = in + amount
}

object FasterCounterMain {
  def main(args: Array[String]): Unit = {

    // Missing arguments for method inc(int)
    // new FasterCounter(10).inc
    println(new FasterCounter(10).inc().dec.inc.inc.count)

    // inorder to write
    // new FasterCounter(10).inc
    // need to include one overloaded method without parameter
    // calling inc means should dec/inc by one

    println(new FasterCounter(20).inc.count)

    println(new FasterCounter(20).dec(10).inc.count)
    println(new FasterCounter(10).inc.inc(5).dec.dec(10).count)
    println(new FasterCounter(30).inc.inc(10).count)

    val adder= new Adder(5)
    println(new FasterCounter(20).adjust(adder).count)

  }
}
