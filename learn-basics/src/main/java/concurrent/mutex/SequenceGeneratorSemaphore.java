package concurrent.mutex;

import java.util.concurrent.Semaphore;

/**
 * SequenceGeneratorSynchronizedMethod.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/04
 **/
public class SequenceGeneratorSemaphore extends SequenceGenerator {

  private Semaphore mutex = new Semaphore(1);

  @Override
  public int getNextSequence() {
    try {
      mutex.acquire();
      return super.getNextSequence();
    } catch (InterruptedException e) {
      return 0;
    } finally {
      mutex.release();
    }
  }
}