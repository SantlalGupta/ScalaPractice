package essentialScala.chapter2

import org.junit.Test

class TestCalc {

  @Test
  def itShouldProduceSameReturnTypeOfPassingArgument()={
    assert(calc.square(12).isInstanceOf[Int])
    assert(calc.square(12.0).isInstanceOf[Double])

    assert(calc.cube(12).isInstanceOf[Int])
    assert(calc.cube(12.0).isInstanceOf[Double])

  }

 /* //this test will fail
  @Test
  def itShouldProduceFailTestAsComparingWithWrongType()={
    assert(calc.square(12).isInstanceOf[Double])

  }*/

  @Test
  def itShouldProduceValidOutputOfTheArgumentPassed()={

    assert(calc.square(2)==4)
    assert(calc.cube(2)==8)
    assert(calc.square(-2)==4)
    assert(calc.cube(-2)== -8)

    assert(calc.square(2.0)==4.0)
    assert(calc.cube(2.0)==8.0)
    assert(calc.square(-2.0)==4.0)
    assert(calc.cube(-2.0)== -8.0)

  }
}
