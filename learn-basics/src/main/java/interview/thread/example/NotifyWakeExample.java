package interview.thread.example;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/** @author zhaoxiaoping @Description: notify 唤醒顺序示例 @Date 2021-10-25 */
public class NotifyWakeExample {
  // 等待列表, 用来记录等待的顺序
  private static List<String> waitList = new LinkedList<>();
  // 唤醒列表, 用来唤醒的顺序
  private static List<String> notifyList = new LinkedList<>();

  private static Object lock = new Object();

  public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < 50; i++) {
      new Thread(
              () -> {
                synchronized (lock) {
                  String threadName = Thread.currentThread().getName();
                  System.out.println("线程 [" + threadName + "] 正在等待");
                  waitList.add(threadName);
                  try {
                    lock.wait();
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                  System.out.println("线程 [" + threadName + "] 被唤醒");
                  notifyList.add(threadName);
                }
              })
          .start();
      TimeUnit.MILLISECONDS.sleep(50);
    }

    for (int i = 0; i < 50; i++) {
      synchronized (lock) {
        lock.notify();
        // synchronized 代码块中 sleep 时, 由于不会释放锁, 被唤醒的线程会进入阻塞队列中, 又因为 synchronized 是非公平锁, 所以会导致唤醒的线程乱序
        //        TimeUnit.MILLISECONDS.sleep(10);
      }
      TimeUnit.MILLISECONDS.sleep(10);
    }
    TimeUnit.SECONDS.sleep(1);
    System.out.println("wait顺序:" + waitList.toString());
    System.out.println("唤醒顺序:" + notifyList.toString());
  }
}
