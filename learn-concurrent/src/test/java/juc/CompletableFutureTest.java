package juc;

import cn.hutool.core.convert.Convert;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author zhaoxiaoping
 * @date 2023-9-20
 */
@Slf4j
public class CompletableFutureTest {
  @Test
  public void testCompletableGet() throws ExecutionException, InterruptedException {
    CompletableFuture<String> f =
        CompletableFuture.supplyAsync(
            () -> {
              sleep(TimeUnit.SECONDS, 1);
              return "商品A";
            });
    log.info("getNow 方法测试：{}", f.getNow("商品B"));

    CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> 1 / 0);
    //    log.info("join 方法测试：{}", f1.join());

    CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> 1 / 0);
    log.info("get 方法测试：{}", f2.get());
  }

  @Test
  public void testCompletableThenRun() throws ExecutionException, InterruptedException {
    long startTime = System.currentTimeMillis();
    CompletableFuture<Void> f1 =
        CompletableFuture.runAsync(() -> sleep(TimeUnit.MILLISECONDS, 600));
    CompletableFuture<Void> f2 = f1.thenRun(() -> sleep(TimeUnit.MILLISECONDS, 400));
    log.info("f2: {}", f2.get());
    log.info("总共用时: {}", (System.currentTimeMillis() - startTime) + "ms");
  }

  @Test
  public void testCompletableThenAccept() throws ExecutionException, InterruptedException {
    long startTime = System.currentTimeMillis();
    CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "success");
    CompletableFuture<Void> f2 = f1.thenAccept(r -> log.info("上一个任务的返回值：{}", r));
    log.info("f2: {}", f2.get());
    log.info("总共用时: {}", (System.currentTimeMillis() - startTime) + "ms");
  }

  @Test
  public void testCompletableThenApply() throws ExecutionException, InterruptedException {
    long startTime = System.currentTimeMillis();
    CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "success");
    CompletableFuture<String> f2 = f1.thenApply(r -> r + " " + r);
    log.info("f2: {}", f2.get());
    log.info("总共用时: {}", (System.currentTimeMillis() - startTime) + "ms");
  }

  @Test
  public void testCompletableWhenComplete() throws ExecutionException, InterruptedException {
    CompletableFuture<Double> f =
        CompletableFuture.supplyAsync(
                () -> {
                  if (Math.random() < 0.5) {
                    throw new RuntimeException("系统错误");
                  }
                  return 0.6;
                })
            .whenComplete(
                (r, t) -> {
                  log.info("任务执行结果: {}", r);
                  log.info("异常信息：", Optional.ofNullable(t).map(Throwable::getMessage).orElse(""));
                });
    log.info("f: {}", f.get());
  }

  @Test
  public void testWhenCompleteExceptionally() throws ExecutionException, InterruptedException {
    CompletableFuture<Double> f =
        CompletableFuture.supplyAsync(
                () -> {
                  if (Math.random() < 0.5) {
                    throw new RuntimeException("系统错误");
                  }
                  return 0.6;
                })
            .whenComplete(
                (r, t) -> {
                  log.info("任务执行结果: {}", r);
                  log.info("异常信息：", Optional.ofNullable(t).map(Throwable::getMessage).orElse(""));
                })
            .exceptionally(
                t -> {
                  log.info("任务执行异常：{}", t.getMessage());
                  return 0.0;
                });
    log.info("f: {}", f.get());
  }

  @Test
  public void testCompletableHandle() throws ExecutionException, InterruptedException {
    CompletableFuture<String> f =
        CompletableFuture.supplyAsync(
                () -> {
                  if (Math.random() < 0.5) {
                    throw new RuntimeException("系统错误");
                  }
                  return 0.6;
                })
            .handle(
                (r, t) -> {
                  log.info("任务执行结果: {}", r);
                  log.info("异常信息：", Optional.ofNullable(t).map(Throwable::getMessage).orElse(""));
                  return Convert.toStr(r);
                });
    log.info("f: {}", f.get());
  }

  @Test
  public void testCompletableAnd() throws ExecutionException, InterruptedException {
    CompletableFuture<Integer> f1 =
        CompletableFuture.supplyAsync(
            () -> {
              log.info("异步任务1，当前线程是：{}", Thread.currentThread().getId());
              System.out.println("异步任务1结束");
              return 1;
            });
    CompletableFuture<Integer> f2 =
        CompletableFuture.supplyAsync(
            () -> {
              log.info("异步任务2，当前线程是：{}", Thread.currentThread().getId());
              System.out.println("异步任务2结束");
              return 2;
            });
    CompletableFuture<Integer> f3 =
        f1.thenCombine(
            f2,
            (r1, r2) -> {
              log.info("执行任务3，当前线程是：{}", Thread.currentThread().getId());
              log.info("任务1返回值：{}", r1);
              log.info("任务2返回值：{}", r2);
              return r1 + r2;
            });
    log.info("任务执行结果：{}", f3.get());
  }

  @Test
  public void testCompletableOr() throws ExecutionException, InterruptedException {
    CompletableFuture<Integer> f1 =
        CompletableFuture.supplyAsync(
            () -> {
              log.info("异步任务1，当前线程是：{}", Thread.currentThread().getId());
              System.out.println("异步任务1结束");
              return 1;
            });
    CompletableFuture<Integer> f2 =
        CompletableFuture.supplyAsync(
            () -> {
              log.info("异步任务2，当前线程是：{}", Thread.currentThread().getId());
              System.out.println("异步任务2结束");
              return 2;
            });
    CompletableFuture<Void> f3 =
        f1.acceptEither(
            f2,
            r -> {
              log.info("执行任务3，当前线程是：{}", Thread.currentThread().getId());
              log.info("上一个任务返回值：{}", r);
            });
    log.info("任务执行结果：{}", f3.get());
  }

  @Test
  public void testCompletableAllOf() throws ExecutionException, InterruptedException {
    CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> 1);
    CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> 2);
    CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "f3");
    // 任务组合
    CompletableFuture<Void> allOf = CompletableFuture.allOf(f1, f2, f3);
    // 等待所有任务完成
    allOf.get();
    // 获取任务结果
    log.info("f1 执行结果：{}", f1.get());
    log.info("f2 执行结果：{}", f2.get());
    log.info("f3 执行结果：{}", f3.get());
  }

  @Test
  public void testCompletableAnyOf() throws ExecutionException, InterruptedException {
    long startTime = System.currentTimeMillis();
    CompletableFuture<Integer> f1 =
        CompletableFuture.supplyAsync(
            () -> {
              sleep(TimeUnit.SECONDS, 1);
              return 1;
            });
    CompletableFuture<Integer> f2 =
        CompletableFuture.supplyAsync(
            () -> {
              sleep(TimeUnit.SECONDS, 1);
              return 2;
            });
    CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "f3");
    // 任务组合
    CompletableFuture<Object> anyOf = CompletableFuture.anyOf(f1, f2, f3);
    // 获取任务结果
    log.info("任务执行结果：{}", anyOf.get());
    log.info("总共用时: {}", (System.currentTimeMillis() - startTime) + "ms");
  }

  private void sleep(TimeUnit unit, long timeout) {
    try {
      unit.sleep(timeout);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
