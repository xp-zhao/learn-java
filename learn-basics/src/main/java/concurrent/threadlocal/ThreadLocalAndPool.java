package concurrent.threadlocal;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadLocalAndPool.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/14
 **/
public class ThreadLocalAndPool {

  private static ThreadLocal<Integer> local = ThreadLocal.withInitial(() -> 0);

  public static int get() {
    return local.get();
  }

  public static void remove() {
    local.remove();
  }

  public static void increment() {
    local.set(local.get() + 1);
  }

  public static void main(String[] args) {
    ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
        .setNameFormat("thread-local-test").build();
    ExecutorService service = new ThreadPoolExecutor(
        2,
        2,
        0,
        TimeUnit.SECONDS,
        new LinkedBlockingQueue<>(12), namedThreadFactory);
    for (int i = 0; i < 5; i++) {
      service.execute(() -> {
        try {
          long threadId = Thread.currentThread().getId();
          int before = get();
          increment();
          int after;
          after = get();
          System.out.println("threadid " + threadId + "  before " + before + ", after " + after);
        } finally {
          remove();
        }
      });
    }
    service.shutdown();
  }
}