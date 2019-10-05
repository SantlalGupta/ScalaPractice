package practice

import java.util.Arrays


 class CustomeArrayList[E] {

  private val INTIAL_CAPACIY:Int= 5
  var size:Int=0
  private var element:Array[Object]=Array()

  /**
   * Add the element in the list
   * @param e Element to be added
   */
  def add(e:E): Unit = {
    if(size==0){
      element = new Array[Object](INTIAL_CAPACIY)
    } else if(size==element.length) {
      ensureCapacity() // increase the capacity of the list
    }
    element(size) = e.asInstanceOf[Object]
    size +=  1
  }

  /**
   * This method will move element from index to size to RHS by 1
   * and put new element at specified index
   * @param index index at which new element should be placed
   * @param e     data to be put in arraylist
   */
  def add(index:Int,e:E) = {
    if(size==0){
      element = new Array[Object](INTIAL_CAPACIY)
    } else if(size == element.length){
      ensureCapacity()
    }
    // this will move element from index to size TO index+1 to size
    System.arraycopy(element,index,element,index+1,size-index)
    element(index)=e.asInstanceOf[Object]
    size +=1

  }

  /**
   * Return element at specified index
   * @param index read the element at specified index
   * @return Return the element at specified index
   */
  def get(index:Int):E = {
    if(index<0 || index>=size) {
      throw new IndexOutOfBoundsException("index: " + index + ", size:" + size)
    }

    element(index).asInstanceOf[E]
  }

  /**
   * It will move element from index to size to LHS by 1 place
   *
   * @param index Get the element at specified index
   * @return Return the element at specified index
   */
  def remove(index:Int) : E = {
    if(index<0 || index >= size) {
      throw new IndexOutOfBoundsException("index: " + index + ", size: " + size)
    }
    val ret = element(index).asInstanceOf[E]
    /*for(i <- index to size-1) {
      element(i) =  element(i+1)
    }
    // OR
    */
    System.arraycopy(element,index + 1, element,index,size-index)
    size -= 1
    ret
  }

  /**
   * This will increase capacity of arraylist as it's double
   */
  def ensureCapacity(): Unit = {
    val newCapacity = element.length*2
    element = Arrays.copyOf(element,newCapacity)
  }

  def display = {
    for(i <- 0 to size-1) {
      print(element(i) + " ")
    }
  }
}

object CustomeArrayList1 {
  def main(args: Array[String]): Unit = {

    val custom = new CustomeArrayList[Int]()
    custom.add(1)
    custom.add(2)
    custom.add(3)
    custom.add(4)
    custom add 5
    custom add 6
    custom add 7
    custom add 8

    custom.display

    println("\n" + custom.remove(3))
    println( custom.get(5))
    custom.display
    custom.add(2,10)
    println()
    custom.display
  }
}
