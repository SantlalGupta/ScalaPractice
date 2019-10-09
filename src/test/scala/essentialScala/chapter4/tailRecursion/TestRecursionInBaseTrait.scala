package essentialScala.chapter4.tailRecursion

import org.junit.Test

class TestRecursionInBaseTrait {

  @Test
  def itShouldLenthAndItsChildLength = {
    //given
    val exa = PairL(1,PairL(2,PairL(3,EndL)))
    //when

    //then
    assert(exa.length==3)
    assert(exa.tail.length==2)
    assert(exa.tail.asInstanceOf[PairL].tail.length==1)
    assert(EndL.length == 0)
  }
}
