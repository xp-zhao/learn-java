package concurrent.threadsafety.threadlocalfield;

import java.util.Arrays;
import java.util.List;

/**
 * ThreadA.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/07
 **/
public class ThreadB extends Thread {

  private final List<String> letters = Arrays.asList("a", "b", "c", "d", "e", "f");

  @Override
  public void run() {
    letters.forEach(System.out::println);
  }
}