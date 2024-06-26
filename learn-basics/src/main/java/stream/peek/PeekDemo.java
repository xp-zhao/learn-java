package stream.peek;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * PeekDemo.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/31
 **/
public class PeekDemo {

  public static void main(String[] args) {
    Stream<String> nameStream = Stream.of("Alice", "Bob", "Chuck");
//    nameStream.peek(System.out::println);
    List<String> list = nameStream.filter(e -> e.length() > 3)
        .peek(e -> System.out.println("Filtered value: " + e))
        .map(String::toUpperCase)
        .peek(e -> System.out.println("Mapped value: " + e))
        .collect(Collectors.toList());
//    System.out.println(list);
    Stream.of("one", "two", "three")
        .peek(e -> e.toUpperCase())
        .forEach(System.out::println);
  }
}