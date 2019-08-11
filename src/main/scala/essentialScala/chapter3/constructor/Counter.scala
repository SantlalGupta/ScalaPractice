package essentialScala.chapter3.constructor

class Counter(val count:Int) {

  def inc : Counter = new Counter(count+1)

  def dec : Counter= new Counter(count-1)

}

object CounterMain {
  def main(args: Array[String]): Unit = {
    println(new Counter(10).inc.dec.inc.inc.count)
  }
}
