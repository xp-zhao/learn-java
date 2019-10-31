package stream.reduce;

import java.util.Arrays;
import java.util.List;

/**
 * ReduceException.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/31
 **/
public class ReduceException {

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    int divider = 2;
    int result = numbers.stream()
        .reduce(0, (a, b) -> divide(a, divider) + divide(b, divider));
    System.out.println(result);
  }

  public static int divide(int value, int factor) {
    int result = 0;
    try {
      result = value / factor;
    } catch (ArithmeticException e) {
      System.err.println("Arithmetic Exception: Division by Zero");
    }
    return result;
  }
}