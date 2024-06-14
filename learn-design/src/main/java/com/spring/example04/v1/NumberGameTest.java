package com.spring.example04.v1;

import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @author zhaoxiaoping
 * @date 2024-6-13
 */
public class NumberGameTest {
  @Test
  public void testNumber() {
    int number = 1;
    String result = NumberGame.input(number);
    Assert.isTrue("1".equals(result));
  }

  @Test
  public void testFizz() {
    int number = 3;
    String result = NumberGame.input(number);
    Assert.isTrue("Fizz".equals(result));
  }

  @Test
  public void testBuzz() {
    int number = 5;
    String result = NumberGame.input(number);
    Assert.isTrue("Buzz".equals(result));
  }

  @Test
  public void testFizzBuzz() {
    int number = 15;
    String result = NumberGame.input(number);
    Assert.isTrue("FizzBuzz".equals(result));
  }
}
