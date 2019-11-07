package concurrent.threadsafety.readwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLockCounter.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/07
 **/
public class ReentrantReadWriteLockCounter {

  private int counter;
  private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
  private final Lock readLock = rwLock.readLock();
  private final Lock writeLock = rwLock.writeLock();

  public void incrementCounter() {
    writeLock.lock();
    try {
      counter += 1;
    } finally {
      writeLock.unlock();
    }
  }

  public int getCounter() {
    readLock.lock();
    try {
      return counter;
    } finally {
      readLock.unlock();
    }
  }

  public ReentrantReadWriteLockCounter(int counter) {
    this.counter = counter;
  }
}