package concurrent;

import java.util.concurrent.atomic.LongAdder;

/**
 * VolatileNotAtomic.java volatile关键字示例
 *
 * @author: zhaoxiaoping
 * @date: 2019/09/10
 **/
public class VolatileNotAtomic {

  private static final int NUMBER = 10000;
  private static LongAdder longAdder = new LongAdder();

  public static void main(String[] args) {
    Thread thread = new Thread(() -> {
      for (int i = 0; i < NUMBER; i++) {
        longAdder.decrement();
      }
    }, "thread");
    thread.start();
    for (int i = 0; i < NUMBER; i++) {
      longAdder.increment();
    }
    while (thread.isAlive()) {

    }

    System.out.println("count 最后的值为：" + longAdder.intValue());
  }
}