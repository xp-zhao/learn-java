package com.spring.example04.v1;

/**
 * @author zhaoxiaoping
 * @date 2024-6-13
 */
public class NumberGame {
  public static String input(int n) {
    if (((n % 3) == 0) && ((n % 5) == 0)) {
      return "FizzBuzz";
    }
    if ((n % 3) == 0) {
      return "Fizz";
    }
    if ((n % 5) == 0) {
      return "Buzz";
    }
    return String.valueOf(n);
  }
}
