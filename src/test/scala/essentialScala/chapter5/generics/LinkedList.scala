package essentialScala.chapter5.generics

import essentialScala.chapter5.Generics.{EndL, Failure, PairL, Success}
import org.junit.Test

class LinkedListTest {

  @Test
  def itShouldFindLengthOfLinkedList() = {
    // given

    //when
    val pair=PairL(2,PairL(4,PairL(6,PairL(8,EndL()))))

    //then
    assert(pair.length==4)
    assert(EndL().length ==0 )
  }

  @Test
  def itShouldCheckExitenceOfElementInTheList() = {
    // given

    //when
    val pair=PairL(2,PairL(4,PairL(6,PairL(8,EndL()))))

    //then
    assert(pair.contains(4))
    assert(EndL().contains(0) == false )
  }

  @Test
  def itShouldFindElementAtIndex() = {
    // given

    //when
    val pair=PairL(2,PairL(4,PairL(6,PairL(8,EndL()))))

    //then
    assert(pair(1)==Success(4))
    assert(pair(3)==Success(8))
    assert(pair(7)==Failure("Index out of bound"))
  }

  @Test
  def itShouldFindDataOfStringTypeinLinedListAtIndex() = {
    // given

    //when
    val pair=PairL("Zero",PairL("One",PairL("Two",PairL("Three",EndL()))))

    //then
    assert(pair(1)==Success("One"))
    assert(pair(3)==Success("Three"))
    assert(pair(7)==Failure("Index out of bound"))
  }
}
