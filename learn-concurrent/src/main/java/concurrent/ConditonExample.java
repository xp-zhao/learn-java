package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhaoxiaoping
 * @Description: Condition精准通知唤醒线程示例 三个线程，交替打印 A->B->C->A->B->C...
 * @Date 2020/4/29
 **/
public class ConditonExample {

  public static void main(String[] args) {
    Data data = new Data();
    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        data.printA();
      }
    }, "A").start();
    new Thread(() -> {
      for (int i = 0; i < 1; i++) {
        data.printB();
      }
    }, "B").start();
    new Thread(() -> {
      for (int i = 0; i < 1; i++) {
        data.printC();
      }
    }, "C").start();
  }


}

class Data {

  private Lock lock = new ReentrantLock();
  private Condition conditionA = lock.newCondition();
  private Condition conditionB = lock.newCondition();
  private Condition conditionC = lock.newCondition();
  /**
   * 1->A,2->B,3->C
   */
  private int number = 1;


  public void printA() {
    lock.lock();
    try {
      while (number != 1) {
        // 等待
        conditionA.await();
      }
      System.out.println(Thread.currentThread().getName() + "->A");
      // 唤醒指定的线程
      number = 2;
      conditionB.signal();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void printB() {
    lock.lock();
    try {
      while (number != 2) {
        // 等待
        conditionB.await();
      }
      System.out.println(Thread.currentThread().getName() + "->B");
      // 唤醒指定的线程
      number = 3;
      conditionC.signal();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void printC() {
    lock.lock();
    try {
      while (number != 3) {
        // 等待
        conditionC.await();
      }
      System.out.println(Thread.currentThread().getName() + "->C");
      // 唤醒指定的线程
      number = 1;
      conditionA.signal();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }
}