package concurrent.example.sequence;

import java.util.concurrent.Semaphore;

/**
 * 让 T1, T2, T3 三个线程顺序执行-通过 Semaphore 实现
 *
 * @author zhaoxiaoping
 * @date 2023-7-11
 */
public class SeqBySemaphore {
  public static void main(String[] args) throws InterruptedException {
    Semaphore semaphore = new Semaphore(1);
    semaphore.acquire();
    Thread t1 = new Thread(new MyThread(semaphore), "T1");
    t1.start();
    semaphore.acquire();
    Thread t2 = new Thread(new MyThread(semaphore), "T2");
    t2.start();
    semaphore.acquire();
    Thread t3 = new Thread(new MyThread(semaphore), "T3");
    t3.start();
  }

  static class MyThread implements Runnable {
    private final Semaphore semaphore;

    public MyThread(Semaphore semaphore) {
      this.semaphore = semaphore;
    }

    @Override
    public void run() {
      System.out.println(Thread.currentThread().getName() + " is Running");
      semaphore.release();
    }
  }
}
