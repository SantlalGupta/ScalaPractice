package essentialScala.chapter4.sealedTrait

import org.junit.{Assert, Test}

class TestDrawShapeColor {

  @Test
  def itShouldProduceLightColor: Unit ={
    Assert.assertFalse(Square(1.2,Red).color.isLight)
    Assert.assertTrue(Square(1.2,Pink).color.isLight)
    Assert.assertTrue(Square(1.2,CustomColor(0.6,0.5,0.5)).color.isLight)
    Assert.assertTrue(CustomColor(0.5,0.6,0.7).isLight)
  }

  @Test
  def itShouldProduceStringValueofColor = {
    Assert.assertEquals(DrawShapeColor(Red),"Red")
    Assert.assertEquals(DrawShapeColor(Yellow),"Yellow")
    Assert.assertEquals(DrawShapeColor(Pink),"Pink")
    Assert.assertEquals(DrawShapeColor(CustomColor(0.1,0.2,0.3)),"Dark")
    Assert.assertEquals(DrawShapeColor(CustomColor(0.6,0.7,0.8)),"Light")
  }
}

