package com.spring.example04.v2;

import com.spring.example04.v1.NumberGame;
import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @author zhaoxiaoping
 * @date 2024-6-14
 */
public class NumberGameV2Test {
    @Test
    public void testNumber() {
        int number = 1;
        String result = NumberGameV2.input(number);
        Assert.isTrue("1".equals(result));
    }

    @Test
    public void testFizz() {
        int number = 3;
        String result = NumberGameV2.input(number);
        Assert.isTrue("Fizz".equals(result));
    }

    @Test
    public void testBuzz() {
        int number = 5;
        String result = NumberGameV2.input(number);
        Assert.isTrue("Buzz".equals(result));
    }

    @Test
    public void testFizzBuzz() {
        int number = 15;
        String result = NumberGameV2.input(number);
        Assert.isTrue("FizzBuzz".equals(result));
    }
}
