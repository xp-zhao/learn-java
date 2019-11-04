package concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * LoginQueueUsingSemaphore.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/04
 **/
public class LoginQueueUsingSemaphore {

  private Semaphore semaphore;

  public LoginQueueUsingSemaphore(int slotLimit) {
    semaphore = new Semaphore(slotLimit);
  }

  boolean tryLogin() {
    return semaphore.tryAcquire();
  }

  void logout() {
    semaphore.release();
  }

  int availableSlots() {
    return semaphore.availablePermits();
  }
}