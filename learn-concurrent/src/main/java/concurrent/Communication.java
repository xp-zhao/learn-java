package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhaoxiaoping
 * @Description: 线程间的通信问题：生产者、消费者问题； 等待唤醒、通知唤醒
 * @Date 2020/4/27
 **/
public class Communication {

  /**
   * 线程交替执行 A B 两个线程操作同一个变量 num = 0 A num + 1 B num - 1
   */
  public static void main(String[] args) {
    Data2 data = new Data2();
    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        try {
          data.increment();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }, "A").start();
    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        try {
          data.decrement();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }, "B").start();
    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        try {
          data.increment();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }, "C").start();
    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        try {
          data.decrement();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }, "D").start();
  }

  static class Data {

    private int number = 0;

    /**
     * +1 操作
     */
    public synchronized void increment() throws InterruptedException {
      while (number != 0) {
        // 等待
        this.wait();
      }
      number++;
      System.out.println(Thread.currentThread().getName() + "=>" + number);
      // 通过其它线程
      this.notifyAll();
    }

    /**
     * -1 操作
     */
    public synchronized void decrement() throws InterruptedException {
      while (number == 0) {
        // 等待
        this.wait();
      }
      number--;
      System.out.println(Thread.currentThread().getName() + "=>" + number);
      // 通知其它线程
      this.notifyAll();
    }
  }

  static class Data2 {

    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    /**
     * +1 操作
     */
    public void increment() throws InterruptedException {
      lock.lock();
      try {
        while (number != 0) {
          // 等待
          condition.await();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        // 通过其它线程
        condition.signalAll();
      } finally {
        lock.unlock();
      }
    }

    /**
     * -1 操作
     */
    public synchronized void decrement() throws InterruptedException {
      lock.lock();
      try {
        while (number == 0) {
          // 等待
          condition.await();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        // 通知其它线程
        condition.signalAll();
      } finally {
        lock.unlock();
      }
    }
  }
}
