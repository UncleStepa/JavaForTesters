package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTests {

  @Test
  public void test0() {
    Equation e = new Equation(1,1,1);
    Assert.assertEquals(e.rootNamber(), 0);
  }

  @Test
  public void test1() {
    Equation e = new Equation(1,2,1);
    Assert.assertEquals(e.rootNamber(), 1);
  }

  @Test
  public void test3() {
    Equation e = new Equation(1,5,6);
    Assert.assertEquals(e.rootNamber(), 2);
  }
}
