package practice

import org.junit.Test

class TestCustomeArrayList {

  @Test
  def itShouldAddElementInTheListAndSizeEqualsToNumberOfElement() = {
    val list = new CustomeArrayList[String]()

    list.add("one")

    assert(list.size==1)
  }

  @Test
  def itShouldGiveSizeAsZeroWhenNoElementWereAdded() = {
    // given
    val list = new CustomeArrayList[String]()
    //when

    //then
    assert(list.size==0)
  }

  @Test
  def itShouldGrowAndShrinkAsTheListAsElementsWereAddedOrRemoved() = {
    // given
    val list = new CustomeArrayList[String]()

    //when
    list add "One"
    list add "two"
    list add "three"
    list add "four"
    list add "five"
    list add "Six"
    list add "Seven"

    //then
    assert(list.size == 7)

    list add "Eight"

    assert(list.size == 8)

    list remove 2
    list remove 3

    assert (list.size == 6)

    //then
  }

  @Test
  def itShouldBeAbleToAddElementAtSpecificIndex = {
    //given
    val list = new CustomeArrayList[Int]()

    //when
    list add 1
    list add 2
    list add 3
    list add 4
    list add 5
    list add(2,10)

    //then
    assert(list.get(2)==10)
  }

  @Test(expected = classOf[java.lang.IndexOutOfBoundsException])
  def itShouldThrowExceptionWhenWeTryToElemenIndextNotPresentInList = {
    //given
    val list = new CustomeArrayList[Int]()

    //when
    list add 1
    list add 2
    list add 3
    list add 4
    list add 5

    //Then
    assert(list.remove(15).isNaN)
  }
}
