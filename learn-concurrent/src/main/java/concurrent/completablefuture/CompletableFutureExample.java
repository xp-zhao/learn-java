package concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.junit.Assert;
import org.junit.Test;

/** @author zhaoxiaoping @Description: CompletableFuture 使用示例集合 @Date 2021-11-3 */
public class CompletableFutureExample {

  @Test
  public void completedFutureExample() {
    // 使用预定义的结果创建一个完成的 CompletableFuture
    CompletableFuture<String> future = CompletableFuture.completedFuture("message");
    Assert.assertTrue(future.isDone());
    Assert.assertEquals("message", future.getNow(null));
  }

  @Test
  public void runAsyncExample() {
    // 创建一个异步执行的任务
    CompletableFuture<Void> future =
        CompletableFuture.runAsync(
            () -> {
              Assert.assertTrue(Thread.currentThread().isDaemon());
              sleep(2 * 1000);
            });
    Assert.assertFalse(future.isDone());
    sleep(3 * 1000);
    Assert.assertTrue(future.isDone());
  }

  @Test
  public void runApplyExample() {
    // 在前一个 CompletableFuture 的基础上, 应用函数(同步, 函数的执行会阻塞)
    CompletableFuture<String> future =
        CompletableFuture.completedFuture("message")
            .thenApply(
                s -> {
                  Assert.assertFalse(Thread.currentThread().isDaemon());
                  return s.toUpperCase();
                });
    Assert.assertEquals("MESSAGE", future.getNow(null));
  }

  @Test
  public void runApplyAsyncExample() {
    // 在前一个阶段完成之后, 异步的应用函数
    CompletableFuture<String> future =
        CompletableFuture.completedFuture("message")
            .thenApplyAsync(
                s -> {
                  Assert.assertTrue(Thread.currentThread().isDaemon());
                  sleep(5 * 1000);
                  return s.toUpperCase();
                });
    Assert.assertNull(future.getNow(null));
    Assert.assertEquals("MESSAGE", future.join());
  }

  @Test
  public void runApplyAsyncWithExecutorExample() {
    ExecutorService executor =
        Executors.newFixedThreadPool(
            3,
            new ThreadFactory() {
              int count = 1;

              @Override
              public Thread newThread(Runnable r) {
                return new Thread(r, "custom-executor-" + count++);
              }
            });
    // 使用自定义的 Executor 在前一个阶段完成之后, 异步的应用函数
    CompletableFuture<String> future =
        CompletableFuture.completedFuture("message")
            .thenApplyAsync(
                s -> {
                  Assert.assertTrue(
                      Thread.currentThread().getName().startsWith("custom-executor-"));
                  Assert.assertFalse(Thread.currentThread().isDaemon());
                  sleep(5 * 1000);
                  return s.toUpperCase();
                },
                executor);
    Assert.assertNull(future.getNow(null));
    Assert.assertEquals("MESSAGE", future.join());
  }

  @Test
  public void runAcceptExample() {
    // 消费前一个阶段的接口, 同步执行
    CompletableFuture.completedFuture("message")
        .thenAccept(
            s -> {
              sleep(1 * 1000);
              System.out.println(s);
            });
    System.out.println("xxx");
  }

  @Test
  public void runAcceptAsyncExample() {
    // 消费前一个阶段的接口, 异步执行
    CompletableFuture<Void> future =
        CompletableFuture.completedFuture("message")
            .thenAcceptAsync(
                s -> {
                  sleep(1 * 1000);
                  System.out.println(s);
                });
    System.out.println("xxx");
    future.join();
  }

  @Test
  public void completeExceptionallyExample() {
    CompletableFuture<String> future =
        CompletableFuture.completedFuture("message").thenApplyAsync(String::toUpperCase);
    CompletableFuture<String> exceptionHandler =
        future.handle((s, th) -> th != null ? "message upon cancel" : "");
    future.completeExceptionally(new RuntimeException("completed exceptionally"));
    System.out.println(future.isCompletedExceptionally());
    try {
      future.join();
      Assert.fail("Should have thrown an exception");
    } catch (CompletionException ex) { // just for testing
      Assert.assertEquals("completed exceptionally", ex.getCause().getMessage());
    }
    Assert.assertEquals("message upon cancel", exceptionHandler.join());
  }

  
  
  private void sleep(long timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
