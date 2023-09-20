package juc;

import java.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author zhaoxiaoping
 * @date 2023-9-19
 */
@Slf4j
public class FutureTest {
  @Test
  public void testFuture() throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    Future<String> future =
        executorService.submit(
            () -> {
              TimeUnit.SECONDS.sleep(2);
              return "success";
            });
    log.info("start");
    log.info("执行结果：{}", future.get());
    log.info("end");
  }

  @Test
  public void testCountDownLatch() throws InterruptedException, ExecutionException {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    CountDownLatch downLatch = new CountDownLatch(2);
    long startTime = System.currentTimeMillis();
    Future<String> userFuture =
        executorService.submit(
            () -> {
              // 模拟查询用户信息耗时500毫秒
              TimeUnit.MILLISECONDS.sleep(500);
              downLatch.countDown();
              return "用户信息";
            });
    Future<String> goodsFuture =
        executorService.submit(
            () -> {
              // 模拟查询商品信息耗时400毫秒
              TimeUnit.MILLISECONDS.sleep(400);
              downLatch.countDown();
              return "商品信息";
            });
    downLatch.await();
    // 模拟主程序耗时时间
    TimeUnit.MILLISECONDS.sleep(600);
    log.info("获取用户信息: {}", userFuture.get());
    log.info("获取商品信息: {}", goodsFuture.get());
    log.info("总共用时: {}", (System.currentTimeMillis() - startTime) + "ms");
  }
}
