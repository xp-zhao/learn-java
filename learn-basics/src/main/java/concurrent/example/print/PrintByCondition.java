package concurrent.example.print;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替打印 A, B - 通过 Condition 实现
 *
 * @author zhaoxiaoping
 * @date 2023-7-11
 */
public class PrintByCondition {
  public static void main(String[] args) {
    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Thread t1 =
        new Thread(
            () -> {
              lock.lock();
              try {
                for (int i = 0; i < 5; i++) {
                  System.out.println("A");
                  conditionA.signal();
                  conditionB.await();
                }
              } catch (Exception e) {
                throw new RuntimeException(e);
              } finally {
                lock.unlock();
              }
            });
    new Thread(
            () -> {
              lock.lock();
              t1.start();
              try {
                for (int i = 0; i < 5; i++) {
                  conditionA.await();
                  System.out.println("B");
                  conditionB.signal();
                }
              } catch (Exception e) {
                throw new RuntimeException(e);
              } finally {
                lock.unlock();
              }
            })
        .start();
  }
}
