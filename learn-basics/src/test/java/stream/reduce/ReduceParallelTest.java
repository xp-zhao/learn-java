package stream.reduce;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * ReduceParallelTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/31
 **/
public class ReduceParallelTest {

  private List<User> userList;

  @Before
  public void setUp() {
    userList = createUsers();
  }

  private List<User> createUsers() {
    List<User> users = new ArrayList<>();
    for (int i = 0; i <= 1000000; i++) {
      users.add(new User("John" + i, i));
    }
    return users;
  }

  @Test
  public void executeReduceOnParallelizedStream() {
    long start = System.currentTimeMillis();
    Integer age = userList
        .parallelStream()
        .reduce(0, (partialAgeResult, user) -> partialAgeResult + user.getAge(), Integer::sum);
    long end = System.currentTimeMillis();
    System.out.println(age + " parallel: " + (end - start));
  }

  @Test
  public void executeReduceOnSequentialStream() {
    long start = System.currentTimeMillis();
    Integer age = userList
        .stream()
        .reduce(0, (partialAgeResult, user) -> partialAgeResult + user.getAge(), Integer::sum);
    long end = System.currentTimeMillis();
    System.out.println(age + " serial: " + (end - start));
  }
}