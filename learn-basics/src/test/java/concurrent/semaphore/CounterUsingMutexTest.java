package concurrent.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import org.junit.Assert;
import org.junit.Test;

/**
 * CounterUsingMutexTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/04
 **/
public class CounterUsingMutexTest {

  @Test
  public void test() {
    int count = 5;
    ExecutorService executorService
        = Executors.newFixedThreadPool(count);
    CounterUsingMutex counter = new CounterUsingMutex();
    IntStream.range(0, count)
        .forEach(user -> executorService.execute(() -> {
          try {
            counter.increase();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }));
    executorService.shutdown();

    Assert.assertTrue(counter.hasQueuedThreads());
  }

  @Test
  public void test1() throws InterruptedException {
    int count = 5;
    ExecutorService executorService
        = Executors.newFixedThreadPool(count);
    CounterUsingMutex counter = new CounterUsingMutex();
    IntStream.range(0, count)
        .forEach(user -> executorService.execute(() -> {
          try {
            counter.increase();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }));
    executorService.shutdown();

    Assert.assertTrue(counter.hasQueuedThreads());
    Thread.sleep(5000);
    Assert.assertFalse(counter.hasQueuedThreads());
    Assert.assertEquals(count, counter.getCount());
  }
}