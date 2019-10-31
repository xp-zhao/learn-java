package stream.reduce;

import java.util.Arrays;
import java.util.List;

/**
 * ReduceDemo.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/31
 **/
public class ReduceDemo {

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    int result = numbers.parallelStream()
        .reduce(0, (subtotal, element) -> subtotal + element, Integer::sum);
    System.out.println(result);

    List<User> users = Arrays.asList(new User("xp1", 22), new User("xp2", 23));
    int ages = users.stream()
        .reduce(0, (partialAge, user) -> partialAge + user.getAge(), Integer::sum);
    System.out.println(ages);
  }
}