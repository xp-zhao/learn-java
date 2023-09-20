package concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-8-28
 **/
public class BasicDemo {

  public static void main(String[] args) throws InterruptedException {
    CompletableFuture cf = CompletableFuture.completedFuture("message").thenApply(s -> s.toUpperCase());
    System.out.println(cf.isDone());
    System.out.println(cf.getNow(null));
    
    CompletableFuture cf1 = CompletableFuture.runAsync(() -> {
      System.out.println(Thread.currentThread().isDaemon());
      try {
        TimeUnit.SECONDS.sleep(20);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    System.out.println("test");
    System.out.println(cf1.isDone());
    TimeUnit.SECONDS.sleep(2);
    System.out.println(cf1.isDone());
  }
}
