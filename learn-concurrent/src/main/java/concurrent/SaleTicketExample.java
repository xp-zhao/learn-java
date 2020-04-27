package concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhaoxiaoping
 * @Description: 多线程售票示例
 * @Date 2020/4/26
 **/
public class SaleTicketExample {

  public static void main(String[] args) {
    Ticket2 ticket = new Ticket2();
    new Thread(() -> {
      for (int i = 0; i < 400; i++) {
        ticket.sale();
      }
    }, "A").start();
    new Thread(() -> {
      for (int i = 0; i < 400; i++) {
        ticket.sale();
      }
    }, "B").start();
    new Thread(() -> {
      for (int i = 0; i < 400; i++) {
        ticket.sale();
      }
    }, "C").start();
    new Thread(() -> {
      for (int i = 0; i < 400; i++) {
        ticket.sale();
      }
    }, "D").start();
  }

  static class Ticket {

    private int number = 300;

    public synchronized void sale() {
      if (number > 0) {
        System.out.println(Thread.currentThread().getName() + "卖出了，"
            + "第 " + (number--) + " 票，剩余：" + number);
        try {
          TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  static class Ticket2 {

    private int number = 300;
    Lock lock = new ReentrantLock();

    public void sale() {
      // 加锁
      lock.lock();
      try {
        if (number > 0) {
          System.out.println(Thread.currentThread().getName() + "卖出了，"
              + "第 " + (number--) + " 票，剩余：" + number);
          try {
            TimeUnit.MILLISECONDS.sleep(1);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      } finally {
        // 解锁
        lock.unlock();
      }
    }
  }
}
