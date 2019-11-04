package concurrent.mutex;

import java.util.concurrent.locks.ReentrantLock;

/**
 * SequenceGeneratorSynchronizedMethod.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/04
 **/
public class SequenceGeneratorReentrantLock extends SequenceGenerator {

  private ReentrantLock mutex = new ReentrantLock();

  @Override
  public int getNextSequence() {
    try {
      mutex.lock();
      return super.getNextSequence();
    } finally {
      mutex.unlock();
    }
  }
}