package concurrent.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
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

  @Test
  public void cancelExample() {
    CompletableFuture<String> future =
        CompletableFuture.completedFuture("message").thenApplyAsync(String::toUpperCase);
    CompletableFuture<String> exceptionally = future.exceptionally(th -> "canceled message");
    System.out.println(future.cancel(true));
    System.out.println(future.isCompletedExceptionally());
    Assert.assertEquals("canceled message", exceptionally.join());
  }

  @Test
  public void applyToEitherExample() {
    // 两个任务只要有一个完成, 就进行执行后续 function (不保证哪一个必须会被执行)
    String original = "message";
    CompletableFuture<String> future1 =
        CompletableFuture.completedFuture(original).thenApplyAsync(String::toUpperCase);
    CompletableFuture<String> future2 =
        future1.applyToEither(
            CompletableFuture.completedFuture(original).thenApplyAsync(String::toLowerCase),
            s -> s + " from applyToEither");
    System.out.println(future2.join());
  }

  @Test
  public void acceptEitherExample() {
    // 两个任务只要有一个完成, 就进行执行后续 consumer (不保证哪一个必须会被执行)
    String original = "message";
    CompletableFuture<Void> future =
        CompletableFuture.completedFuture(original)
            .thenApplyAsync(String::toUpperCase)
            .acceptEither(
                CompletableFuture.completedFuture(original).thenApplyAsync(String::toLowerCase),
                s -> System.out.println(s));
    System.out.println(future.join());
  }

  @Test
  public void runAfterBothExample() {
    // 在两个 CompletableFuture 都结束之后, 执行一个 Runnable
    String original = "message";
    CompletableFuture.completedFuture(original)
        .thenApply(String::toUpperCase)
        .runAfterBoth(
            CompletableFuture.completedFuture(original).thenApply(String::toLowerCase),
            () -> System.out.println(original));
  }

  @Test
  public void thenAcceptBothExample() {
    // 使用BiConsumer处理两个阶段的结果
    String original = "message";
    CompletableFuture.completedFuture(original)
        .thenApply(String::toUpperCase)
        .thenAcceptBoth(
            CompletableFuture.completedFuture(original).thenApply(String::toLowerCase),
            (s1, s2) -> System.out.println(s1 + s2));
  }

  @Test
  public void thenCombineExample() {
    // 使用BiFunction处理两个阶段的结果
    String original = "message";
    CompletableFuture<String> future =
        CompletableFuture.completedFuture(original)
            .thenApply(String::toUpperCase)
            .thenCombine(
                CompletableFuture.completedFuture(original).thenApply(String::toLowerCase),
                (s1, s2) -> s1 + s2);
    System.out.println(future.getNow(null));
  }

  @Test
  public void thenCombineAsyncExample() {
    // 异步使用BiFunction处理两个阶段的结果
    String original = "message";
    CompletableFuture<String> future =
        CompletableFuture.completedFuture(original)
            .thenApply(String::toUpperCase)
            .thenCombine(
                CompletableFuture.completedFuture(original).thenApply(String::toLowerCase),
                (s1, s2) -> s1 + s2);
    System.out.println(future.getNow(null));
  }

  @Test
  public void thenComposeExample() {
    // 组合 CompletableFuture
    String original = "Message";
    CompletableFuture<String> future =
        CompletableFuture.completedFuture(original)
            .thenApply(String::toUpperCase)
            .thenCompose(
                upper ->
                    CompletableFuture.completedFuture(original)
                        .thenApply(String::toLowerCase)
                        .thenApply(s -> upper + s));
    System.out.println(future.join());
  }

  @Test
  public void anyOfExample() {
    // 当几个 CompletableFuture 中的一个完成后，使用 BiConsumer 处理结果
    List<String> messages = Arrays.asList("a", "b", "c");
    List<CompletableFuture<String>> futureList =
        messages.stream()
            .map(msg -> CompletableFuture.completedFuture(msg).thenApply(String::toUpperCase))
            .collect(Collectors.toList());
    CompletableFuture.anyOf(futureList.toArray(new CompletableFuture[futureList.size()]))
        .whenComplete(
            (res, th) -> futureList.forEach(item -> System.out.println(item.getNow(null))));
  }

  @Test
  public void allOfExample() {
    // 当几个 CompletableFuture 全部完成后，使用 BiConsumer 处理结果
    List<String> messages = Arrays.asList("a", "b", "c");
    List<CompletableFuture<String>> futureList =
        messages.stream()
            .map(msg -> CompletableFuture.completedFuture(msg).thenApply(String::toUpperCase))
            .collect(Collectors.toList());
    CompletableFuture.allOf(futureList.toArray(new CompletableFuture[futureList.size()]))
        .whenComplete(
            (res, th) -> futureList.forEach(item -> System.out.println(item.getNow(null))));
  }

  @Test
  public void allOfAsyncExample() {
    // 当几个 CompletableFuture 全部完成后，使用 BiConsumer 处理结果
    List<String> messages = Arrays.asList("a", "b", "c");
    List<CompletableFuture<String>> futureList =
        messages.stream()
            .map(msg -> CompletableFuture.completedFuture(msg).thenApplyAsync(String::toUpperCase))
            .collect(Collectors.toList());
    CompletableFuture<Void> future =
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[futureList.size()]))
            .whenComplete(
                (res, th) -> futureList.forEach(item -> System.out.println(item.getNow(null))));
    System.out.println(future.join());
  }

  private void sleep(long timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
