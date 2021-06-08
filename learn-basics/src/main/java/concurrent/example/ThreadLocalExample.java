package concurrent.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description: ThreadLocal 使用示例
 * @Date 2021-6-8
 **/
@Slf4j
public class ThreadLocalExample {

  private static ThreadLocal<String> currentUser = ThreadLocal.withInitial(() -> null);

  public static void main(String[] args) throws InterruptedException {
    ForkJoinPool forkJoinPool = new ForkJoinPool(1);
    ThreadLocalExample example = new ThreadLocalExample();
    forkJoinPool.execute(() -> {
      example.print();
      example.print();
    });
    forkJoinPool.shutdown();
    forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
  }

  private void print() {
    String before = Thread.currentThread().getName() + ":" + currentUser.get();
    currentUser.set("1");
    try {
      String after = Thread.currentThread().getName() + ":" + currentUser.get();
      Map<String, String> result = new HashMap<>(2);
      result.put("before", before);
      result.put("after", after);
      log.info("ThreadLocal: {}", result);
    } finally {
      // 在使用结束之后删除 ThreadLocal 中的数据, 防止线程重用导致 ThreadLocal 信息错乱
      currentUser.remove();
    }
  }
}
