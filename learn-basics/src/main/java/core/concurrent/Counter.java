package core.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/** @author zhaoxiaoping @Description: 计数器 @Date 2021-11-5 */
public class Counter {
  private AtomicInteger atomic = new AtomicInteger(0);
  private int i = 0;

  public static void main(String[] args) {
    Counter counter = new Counter();
    List<Thread> threads = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      Thread thread =
          new Thread(
              () -> {
                for (int j = 0; j < 10000; j++) {
                  counter.count();
                  counter.safeCount();
                }
              });
      threads.add(thread);
    }
    threads.forEach(Thread::start);
    threads.forEach(
        item -> {
          try {
            item.join();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        });
    System.out.println(counter.i);
    System.out.println(counter.atomic.get());
  }

  private void safeCount() {
    for (; ; ) {
      int i = atomic.get();
      if (atomic.compareAndSet(i, ++i)) {
        break;
      }
    }
  }

  private void count() {
    i++;
  }
}
