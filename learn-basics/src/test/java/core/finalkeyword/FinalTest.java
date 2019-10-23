package core.finalkeyword;

import org.junit.Assert;
import org.junit.Test;

/**
 * FinalTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/23
 **/
public class FinalTest {

  @Test
  public void testCat() {
    Cat cat = new Cat();
    cat.setWeight(1);
    Assert.assertEquals(1, cat.getWeight());
  }
}