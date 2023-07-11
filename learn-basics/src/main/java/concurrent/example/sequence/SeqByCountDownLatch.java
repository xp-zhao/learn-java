package concurrent.example.sequence;

import java.util.concurrent.CountDownLatch;

/**
 * 让 T1, T2, T3 三个线程顺序执行-通过 CountDownLatch 实现
 *
 * @author zhaoxiaoping
 * @date 2023-7-11
 */
public class SeqByCountDownLatch {
  public static void main(String[] args) throws InterruptedException {
    CountDownLatch latch1 = new CountDownLatch(1);
    CountDownLatch latch2 = new CountDownLatch(1);
    CountDownLatch latch3 = new CountDownLatch(1);
    Thread t1 = new Thread(new MyThread(latch1), "T1");
    t1.start();
    // 等待线程 t1 执行完
    latch1.await();
    Thread t2 = new Thread(new MyThread(latch2), "T2");
    t2.start();
    // 等待线程 t2 执行完
    latch2.await();
    Thread t3 = new Thread(new MyThread(latch3), "T3");
    t3.start();
    // 等待线程 t1 执行完
    latch3.await();
  }

  static class MyThread implements Runnable {

    private final CountDownLatch latch;

    public MyThread(CountDownLatch latch) {
      this.latch = latch;
    }

    @Override
    public void run() {
      System.out.println(Thread.currentThread().getName() + " is Running");
      latch.countDown();
    }
  }
}
