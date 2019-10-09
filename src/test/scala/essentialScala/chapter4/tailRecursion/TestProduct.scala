package essentialScala.chapter4.tailRecursion

import org.junit.Test

class TestProduct {

  @Test
  def itShouldTestProductOfNumberInTheList = {
    //given
    val ex = PairP(3,PairP(2,PairP(1,EndP)))
    //when

    //then
    assert(ex.product==6)
    assert(ex.tail.product==2)
    assert(ex.tail.asInstanceOf[PairP].tail.product==1)
    assert(EndP.product==1)

  }
}
