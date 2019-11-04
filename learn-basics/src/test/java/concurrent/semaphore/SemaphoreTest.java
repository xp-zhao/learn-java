package concurrent.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import org.junit.Assert;
import org.junit.Test;

/**
 * SemaphoreTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/04
 **/
public class SemaphoreTest {

  @Test
  public void testLimit() throws InterruptedException {
    final int slots = 10;
    final ExecutorService service = Executors.newFixedThreadPool(slots);
    final LoginQueueUsingSemaphore loginQueue = new LoginQueueUsingSemaphore(slots);
    IntStream.range(0, slots)
        .forEach(user -> service.execute(loginQueue::tryLogin));

    service.shutdown();
    service.awaitTermination(10, TimeUnit.SECONDS);

    Assert.assertEquals(0, loginQueue.availableSlots());
    Assert.assertFalse(loginQueue.tryLogin());
  }

  @Test
  public void testLogout() throws InterruptedException {
    final int slots = 10;
    final ExecutorService service = Executors.newFixedThreadPool(slots);
    final LoginQueueUsingSemaphore loginQueue = new LoginQueueUsingSemaphore(slots);
    IntStream.range(0, slots)
        .forEach(user -> service.execute(loginQueue::tryLogin));

    service.shutdown();
    service.awaitTermination(10, TimeUnit.SECONDS);
    Assert.assertEquals(0, loginQueue.availableSlots());

    loginQueue.logout();
    Assert.assertTrue(loginQueue.availableSlots() > 0);
    Assert.assertTrue(loginQueue.tryLogin());
  }
}