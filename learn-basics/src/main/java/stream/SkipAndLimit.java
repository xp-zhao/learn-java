package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * SkipAndLimit.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
public class SkipAndLimit {

  public static void main(String[] args) {
    skip();

    limit();

    tenEvenNumbers();

    combine();
  }

  private static void combine() {
    List<Integer> evenNumbers = Stream.iterate(0, i -> i + 1)
        .filter(i -> i % 2 == 0)
        .skip(10)
        .limit(10)
        .collect(Collectors.toList());
    System.out.println(evenNumbers);
  }

  private static void tenEvenNumbers() {
    List<Integer> evenNumbers = Stream.iterate(0, i -> i + 1)
        .filter(i -> i % 2 == 0)
        .limit(10)
        .collect(Collectors.toList());
    System.out.println(evenNumbers);
  }

  private static void limit() {
    Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .filter(i -> i % 2 == 0)
        .limit(2)
        .forEach(i -> System.out.print(i + " "));
    System.out.println();
  }

  private static void skip() {
    Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .filter(i -> i % 2 == 0)
        .skip(2)
        .forEach(i -> System.out.print(i + " "));
    System.out.println();
  }
}