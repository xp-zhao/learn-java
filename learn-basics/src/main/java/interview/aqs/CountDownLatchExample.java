package interview.aqs;

import java.util.concurrent.CountDownLatch;

/** @author zhaoxiaoping @Description: CountDownLatch 示例 @Date 2021-10-8 */
public class CountDownLatchExample {
  public static void main(String[] args) throws InterruptedException {
    CountDownLatch startSignal = new CountDownLatch(1);
    int n = 5;
    CountDownLatch doneSignal = new CountDownLatch(n);
    for (int i = 0; i < n; i++) {
      new Thread(new Worker(startSignal, doneSignal)).start();
    }
    startSignal.countDown();
    System.out.println("工作线程开始执行");
    doneSignal.await();
  }

  private static class Worker implements Runnable {

    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    private Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
      this.startSignal = startSignal;
      this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
      try {
        // 为了让所有线程同时开始任务, 先将所有线程阻塞在这
        startSignal.await();
        doWork();
        doneSignal.countDown();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    void doWork() {
      System.out.println(Thread.currentThread().getName());
    }
  }
}
