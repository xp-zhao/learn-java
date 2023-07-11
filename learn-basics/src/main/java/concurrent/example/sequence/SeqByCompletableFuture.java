package concurrent.example.sequence;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 让 T1, T2, T3 三个线程顺序执行-通过 CompleteFuture 实现
 *
 * @author zhaoxiaoping
 * @date 2023-7-11
 */
public class SeqByCompletableFuture {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    // 方式一
    CompletableFuture<Void> future =
        CompletableFuture.runAsync(new MyThread("T1"))
            .thenRun(new MyThread("T2"))
            .thenRun(new MyThread("T3"));
    future.get();
    // 方式二
    CompletableFuture<Void> f1 = CompletableFuture.runAsync(new MyThread("T1"));
    f1.join();
    CompletableFuture<Void> f2 = CompletableFuture.runAsync(new MyThread("T2"));
    f2.join();
    CompletableFuture<Void> f3 = CompletableFuture.runAsync(new MyThread("T3"));
    f3.join();
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
