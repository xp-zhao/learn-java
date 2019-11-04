package concurrent.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import org.junit.Assert;
import org.junit.Test;

/**
 * TimedSemaphoreTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/04
 **/
public class TimedSemaphoreTest {

  @Test
  public void testTimeSemaphore() throws InterruptedException {
    int slots = 50;

    ExecutorService executorService = Executors.newFixedThreadPool(slots);
    DelayQueueUsingTimedSemaphore delayQueue
        = new DelayQueueUsingTimedSemaphore(1, slots);

    IntStream.range(0, slots)
        .forEach(user -> executorService.execute(delayQueue::tryAdd));
    executorService.shutdown();
    executorService.awaitTermination(10, TimeUnit.SECONDS);

    Assert.assertEquals(0, delayQueue.availableSlots());
    Assert.assertFalse(delayQueue.tryAdd());
  }

  @Test
  public void testTimePass() throws InterruptedException {
    int slots = 50;

    ExecutorService executorService = Executors.newFixedThreadPool(slots);
    DelayQueueUsingTimedSemaphore delayQueue
        = new DelayQueueUsingTimedSemaphore(1, slots);

    IntStream.range(0, slots)
        .forEach(user -> executorService.execute(delayQueue::tryAdd));
    executorService.shutdown();
    executorService.awaitTermination(10, TimeUnit.SECONDS);

    Assert.assertEquals(0, delayQueue.availableSlots());
    TimeUnit.SECONDS.sleep(1);

    Assert.assertTrue(delayQueue.availableSlots() > 0);
    Assert.assertTrue(delayQueue.tryAdd());
  }
}