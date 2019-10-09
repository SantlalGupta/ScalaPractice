package essentialScala.chapter4.tailRecursion

import org.junit.Test

class TestDouble {

  @Test
  def itShouldDoDoubleOfTheEachHead = {
    //given
    val ex = PairD(3, PairD(2, PairD(1, EndD)))
    //when

    //then
    assert(ex.double == PairD(6, PairD(4, PairD(2, EndD))))
    assert(ex.tail.double == PairD(4, PairD(2, EndD)))
    assert(ex.tail.asInstanceOf[PairD].tail.double == PairD(2, EndD))
    assert(EndD.double == EndD)
  }
}
