package concurrent.semaphore;

import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.concurrent.TimedSemaphore;

/**
 * DelayQueueUsingTimedSemaphore.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/04
 **/
public class DelayQueueUsingTimedSemaphore {

  private TimedSemaphore timedSemaphore;

  public DelayQueueUsingTimedSemaphore(long period, int slotLimit) {
    timedSemaphore = new TimedSemaphore(period, TimeUnit.SECONDS, slotLimit);
  }

  boolean tryAdd() {
    return timedSemaphore.tryAcquire();
  }

  int availableSlots() {
    return timedSemaphore.getAvailablePermits();
  }
}