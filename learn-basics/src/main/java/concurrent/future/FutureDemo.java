package concurrent.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * FutureDemo.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/24
 **/
public class FutureDemo {

  public static void main(String[] args) {
    ExecutorService service = Executors.newFixedThreadPool(10);

    Future<String> future = service.submit(() -> {
      try {
        TimeUnit.SECONDS.sleep(10);
      } catch (InterruptedException e) {
      }
      return "Hello Future";
    });
    service.shutdown();
//    if (future.isDone()) {ca
      try {
        System.out.println(future.isDone());
        System.out.println(future.isCancelled());
        System.out.println(future.get());
        System.out.println(future.isDone());
        System.out.println(future.isCancelled());
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
//    }
  }
}