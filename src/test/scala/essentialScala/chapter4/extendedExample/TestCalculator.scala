package essentialScala.chapter4.extendedExample

import org.junit.Test

class TestCalculator {

  @Test
  def itShouldAddTwoNumber: Unit ={
    // given
    val sum = Addition(Number(2),Number(3))

    //when

    //then
    assert(sum.eval == 5.0)
  }

  @Test
  def itShoudSubtractTwoNumber: Unit ={
    // given
    val sum = Subtraction(Number(2),Number(3))

    //when

    //then
    assert(sum.eval == -1.0)
  }

  @Test
  def itShoulConvertNumberIntoDouble: Unit ={
    // given
    //when

    //then
    assert(Number(5).eval == 5.0)
  }
}
