package essentialScala.chapter4.tailRecursion

import org.junit.Test

class TestLength {
  @Test
  def itShouldLengthOfNumberOfElement: Unit = {
    // given
    val ex = Pair(3, Pair(2, Pair(1, End)))

    //when

    //then
    assert(ex.length == 3)
  }
}