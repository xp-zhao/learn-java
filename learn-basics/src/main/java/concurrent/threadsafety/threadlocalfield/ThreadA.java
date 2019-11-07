package concurrent.threadsafety.threadlocalfield;

import java.util.Arrays;
import java.util.List;

/**
 * ThreadA.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/07
 **/
public class ThreadA extends Thread {

  private final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

  @Override
  public void run() {
    numbers.forEach(System.out::println);
  }
}