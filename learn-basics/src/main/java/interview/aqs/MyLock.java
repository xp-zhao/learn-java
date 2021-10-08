package interview.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/** @author zhaoxiaoping @Description: 自定义锁 @Date 2021-10-8 */
public class MyLock {

  private final Sync sync = new Sync();

  /** 获取锁 */
  public void lock() {
    sync.acquire(1);
  }

  /** 释放锁 */
  public void unlock() {
    sync.release(1);
  }

  private static class Sync extends AbstractQueuedSynchronizer {
    @Override
    public boolean tryAcquire(int acquire) {
      final Thread current = Thread.currentThread();
      int c = getState();
      if (c == 0) {
        // 没有排队的线程时, 再尝试加锁
        if (!hasQueuedPredecessors() && compareAndSetState(0, 1)) {
          // 记录拿到锁的线程是当前线程
          setExclusiveOwnerThread(current);
          return true;
        }
      } else if (current == getExclusiveOwnerThread()) {
        // 已加锁, 判断加锁的线程和当前线程是不是同一个, 是的话就将 state 累加. (可重入)
        setState(c + acquire);
        return true;
      }
      return false;
    }

    @Override
    protected boolean tryRelease(int release) {
      setState(0);
      return true;
    }
  }
}
