package concurrent.completablefuture;

import cn.hutool.core.date.StopWatch;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;

/** @author zhaoxiaoping @Description: @Date 2021-9-14 */
public class CompleteDemo {

  private static Random random = new Random();

  static int getMoreData() {
    System.out.println("begin to start compute");
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    stopWatch.stop();
    System.out.println(
        "end to start compute. passed " + stopWatch.getTotalTimeSeconds() + " seconds");
    return random.nextInt(1000);
  }

  public static void main(String[] args)
      throws ExecutionException, InterruptedException, IOException {
    CompletableFuture<Integer> future = CompletableFuture.supplyAsync(CompleteDemo::getMoreData);
    CompletableFuture<Integer> f = future.whenComplete(
        (v, e) -> {
          System.out.println(v);
          System.out.println(e);
        });
    System.out.println(f.get());
    System.in.read();
  }
}
