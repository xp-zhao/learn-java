package core.exception.lambda.unchecked;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * LambdaExcptionHandle.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/25
 **/
public class LambdaExcptionHandle {

  public static void main(String[] args) {
    List<Integer> integers = Arrays.asList(3, 9, 8, 0, 7, 10, 20);
    customSort(integers);
    // first
//    integers.forEach(i -> {
//      try {
//        System.out.println(50 / i);
//      } catch (ArithmeticException e) {
//        System.err.println("Arithmetic Exception occured : " + e.getMessage());
//      }
//    });
    // second
//    integers.forEach(lambdaWrapper(i -> System.out.println(50 / i)));
    // third
    integers.forEach(consumerWrapper(i -> System.out.println(50 / i), ArithmeticException.class));
  }

  static Consumer<Integer> lambdaWrapper(Consumer<Integer> consumer) {
    return i -> {
      try {
        consumer.accept(i);
      } catch (ArithmeticException e) {
        System.err.println("Arithmetic Exception occured : " + e.getMessage());
      }
    };
  }

  static <T, E extends Exception> Consumer<T> consumerWrapper(Consumer<T> consumer,
      Class<E> clazz) {
    return i -> {
      try {
        consumer.accept(i);
      } catch (Exception e) {
        try {
          E exCast = clazz.cast(e);
          System.err.println("Exception occured : " + exCast.getMessage());
        } catch (ClassCastException ex) {
          throw ex;
        }
      }
    };
  }

  public static void customSort(List<Integer> list) {
    List<Integer> fixed = Arrays.asList(8, 10);
    List<Integer> sorted = list.stream().sorted((i1, i2) -> {
      if (fixed.contains(i1)) {
        return -1;
      }
      return 1;
    }).collect(Collectors.toList());
    System.out.println(list);
    System.out.println(sorted);
  }
}