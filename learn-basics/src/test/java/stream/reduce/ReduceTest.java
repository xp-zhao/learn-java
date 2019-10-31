package stream.reduce;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * ReduceTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/31
 **/
public class ReduceTest {

  @Test
  public void testReduce() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    int result = numbers.stream()
        .reduce(0, Integer::sum);
    Assertions.assertThat(result).isEqualTo(55);

    int resultParallel = numbers.parallelStream()
        .reduce(0, (a, b) -> a + b);
    Assertions.assertThat(resultParallel).isEqualTo(55);
  }

  @Test
  public void testReduceString() {
    List<String> letters = Arrays.asList("a", "b", "c", "d");

    String result1 = letters.stream()
        .reduce("", (partialString, element) -> partialString + element);
    Assertions.assertThat(result1).isEqualTo("abcd");

    String result2 = letters.stream().reduce("", String::concat);
    Assertions.assertThat(result2).isEqualTo("abcd");

    String result3 = letters.stream()
        .reduce("",
            (partialString, element) -> partialString.toUpperCase() + element.toUpperCase());
    Assertions.assertThat(result3).isEqualTo("ABCD");
  }

}