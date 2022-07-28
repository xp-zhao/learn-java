package annotation.value;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author zhaoxiaoping
 * @date 2022-7-20
 */
public class Example {
  public static void main(String[] args) {
    List<String> list = Arrays.asList("1", "2", "3");
    Predicate<String> predicate = item -> false;
    List<String> r = list.stream().filter(predicate).collect(Collectors.toList());
    System.out.println(r);
  }
}
