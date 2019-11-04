package concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * CounterUsingMutex.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/04
 **/
public class CounterUsingMutex {

  private Semaphore mutex;
  private int count;

  public CounterUsingMutex() {
    mutex = new Semaphore(1);
    count = 0;
  }

  void increase() throws InterruptedException {
    mutex.acquire();
    this.count = this.count + 1;
    Thread.sleep(1000);
    mutex.release();

  }

  int getCount() {
    return this.count;
  }

  boolean hasQueuedThreads() {
    return mutex.hasQueuedThreads();
  }
}