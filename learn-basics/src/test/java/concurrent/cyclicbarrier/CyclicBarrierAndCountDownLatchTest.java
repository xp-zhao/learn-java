package concurrent.cyclicbarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.Assert;
import org.junit.Test;

/**
 * CyclicBarrierAndCountDownLatchTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/08
 **/
public class CyclicBarrierAndCountDownLatchTest {

  @Test
  public void testCountDownLatch() throws InterruptedException {
    CountDownLatch countDownLatch = new CountDownLatch(2);
    Thread thread = new Thread(() -> {
      countDownLatch.countDown();
      countDownLatch.countDown();
    });
    thread.start();
    countDownLatch.await();
    Assert.assertEquals(0, countDownLatch.getCount());
  }

  @Test
  public void testCyclicBarrier() {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    Thread thread = new Thread(() -> {
      try {
        cyclicBarrier.await();
        cyclicBarrier.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (BrokenBarrierException e) {
        e.printStackTrace();
      }
    });
    thread.start();
    Assert.assertEquals(0, cyclicBarrier.getNumberWaiting());
    Assert.assertFalse(cyclicBarrier.isBroken());
  }

  @Test
  public void testCountDownLatchReset(){
    CountDownLatch countDownLatch = new CountDownLatch(7);
    ExecutorService service = Executors.newFixedThreadPool(20);
    List<String> list = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      service.execute(() -> {
        long prevValue = countDownLatch.getCount();
        countDownLatch.countDown();
        if(countDownLatch.getCount() != prevValue){
          list.add("Counted down");
        }
      });
    }
    service.shutdown();
    Assert.assertTrue(list.size() <= 7);
  }

  @Test
  public void testCyclicBarrierReset(){
    CyclicBarrier cyclicBarrier = new CyclicBarrier(7);
    ExecutorService service = Executors.newFixedThreadPool(20);
    List<String> list = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      service.execute(() -> {
        try {
          if(cyclicBarrier.getNumberWaiting() > 0){
            list.add("Count Updated");
          }
          cyclicBarrier.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (BrokenBarrierException e) {
          e.printStackTrace();
        }
      });
    }
    service.shutdown();
    Assert.assertTrue(list.size() > 7);
  }
}