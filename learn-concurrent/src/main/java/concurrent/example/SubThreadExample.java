package concurrent.example;

import java.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;

/**
 * 子线程终止示例
 *
 * @author zhaoxiaoping
 * @date 2024-9-25
 */
@Slf4j
public class SubThreadExample {
  public static void main(String[] args) {
    // 创建固定大小的线程池
    ExecutorService executor = Executors.newFixedThreadPool(10);

    // 存储 Future 对象
    CompletableFuture<Boolean>[] futures = new CompletableFuture[10];
    log.info("start");
    // 提交 10 个任务
    for (int i = 0; i < 10; i++) {
      final int taskId = i;
      futures[i] = CompletableFuture.supplyAsync(() -> queryTask(taskId));
    }

    // 统计结果
    int trueCount = 0;
    int falseCount = 0;
    for (int i = 0; i < futures.length; i++) {
      try {
        // 获取每个任务的结果
        Boolean result = futures[i].get();
        if (result) {
          trueCount++;
        } else {
          falseCount++;
        }
        if (trueCount == 2) {
          // 中断剩下的任务
          for (int j = i + 1; j < futures.length; j++) {
            futures[j].cancel(true);
          }
          break;
        }
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }

    // 输出统计结果
    log.info("True count: {}", trueCount);
    log.info("False count: {}", falseCount);

    // 关闭线程池
    executor.shutdown();
  }

  // 模拟查询任务的方法
  private static Boolean queryTask(int taskId) {
    if (Thread.currentThread().isInterrupted()) {
      return Boolean.FALSE;
    }
    log.info("taskId: {}", taskId);
    // 这里可以放置实际的查询逻辑
    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    // 模拟返回 true 或 false
    return taskId % 2 == 0; // 偶数返回 true，奇数返回 false
  }
}
