package concurrent.example.sequence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 让 T1, T2, T3 三个线程顺序执行-通过 线程池 实现
 *
 * @author zhaoxiaoping
 * @date 2023-7-11
 */
public class SeqByThreadPool {
  public static void main(String[] args) {
    // 创建一个只有一个线程的线程池，然后依次将 t1, t2, t3 提交给它执行
    // 因为线程池内部使用了队列来存储线程，所以线程会按照提交的顺序执行
    ExecutorService executor = Executors.newSingleThreadExecutor();
    executor.submit(new MyThread("T1"));
    executor.submit(new MyThread("T2"));
    executor.submit(new MyThread("T3"));
    executor.shutdown();
  }

  static class MyThread implements Runnable {
    private final String name;

    public MyThread(String name) {
      this.name = name;
    }

    @Override
    public void run() {
      System.out.println(name + " is Running");
    }
  }
}
