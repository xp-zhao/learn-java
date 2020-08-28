import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoxiaoping
 * @Description: CompletableFuture测试
 * @Date 2020/4/17
 **/
public class TestCompletableFuture {

  @Test
  public void testBasic(){
    CompletableFuture cf = CompletableFuture.completedFuture("test");
    System.out.println(cf.getNow("filed"));
  }

  @Test
  public void testAsync(){
    CompletableFuture cf = CompletableFuture.runAsync(() -> {
      System.out.println("async start");
      sleep(2);
      System.out.println("async end");
      Assert.assertTrue(Thread.currentThread().isDaemon());
    });
    Assert.assertFalse(cf.isDone());
    sleep(3);
    Assert.assertTrue(cf.isDone());
  }

  @Test
  public void testThenApply(){
    CompletableFuture cf = CompletableFuture.completedFuture("message").thenApply(s -> {
      Assert.assertFalse(Thread.currentThread().isDaemon());
      return s.toUpperCase();
    });
    Assert.assertEquals("MESSAGE", cf.getNow(null));
  }

  @Test
  public void testThenApplyAsync(){
    CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(s -> {
      Assert.assertTrue(Thread.currentThread().isDaemon());
      sleep(1);
      return s.toUpperCase();
    });
    Assert.assertNull(cf.getNow(null));
    sleep(2);
    Assert.assertEquals("MESSAGE", cf.getNow(null));
  }

  private void sleep(long timeout) {
    try {
      TimeUnit.SECONDS.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    CompletableFuture<String> f0 = CompletableFuture
        .supplyAsync(() -> "hello world")
        .thenApply(s -> s + " QQ")
        .thenApply(String::toUpperCase);
    System.out.println(f0.join());

    /**
     * 异常处理示例
     */
    CompletableFuture<Integer> f1 = CompletableFuture
        .supplyAsync(() -> 7/0)
        .thenApply(r -> r * 10)
        .exceptionally(e -> 0);
    System.out.println(f1.join());
  }
}
