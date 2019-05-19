package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void firstTestDistance() {
    Point p1 = new Point(3.0, 4.0);
    Point p2 = new Point(5.0, 6.0);
    Assert.assertEquals(p1.distance(p2), 2.8284271247461903);

  }

  @Test
  public void secondTestDistance() {
    Point p1 = new Point(3.0, 4.0);
    Point p2 = new Point(5.0, 6.0);
    Assert.assertEquals(Double.toString(p1.distance(p2)), "2.8284271247461903");
  }

  @Test
  public void thirdTestDistance() {
    Point p1 = new Point(1.0, 1.0);
    Point p2 = new Point(1.0, 1.0);
    Assert.assertEquals(p1.distance(p2), 0.0);
  }

  @Test
  public void fourthTestDistance() {
    Point p1 = new Point(1.3, 1.4);
    Point p2 = new Point(-10.0, -10.0);
    Assert.assertEquals(p1.distance(p2), 16.051479682571326);
  }
}
