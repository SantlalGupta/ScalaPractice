package essentialScala.chapter3

import essentialScala.chapter3.constructor.{Cat, ChipShop}
import junit.framework.Assert
import org.junit.Test

class TestCat {

  @Test
  def itShouldReturnTrueWhileServingChipsFalseOtherWise()={

    val os = new Cat("AAA","Black","Chips")
    val hand = new Cat("BBB","White","Red and White")

    Assert.assertTrue(ChipShop.willServe(os))
    Assert.assertFalse(ChipShop.willServe(hand))

  }
}
