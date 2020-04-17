package concurrent;

import com.sun.xml.internal.ws.util.CompletedFuture;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoxiaoping
 * @Description: CompletableFuture 使用示例
 * @Date 2020/4/17
 **/
public class CompletableFutureDemo {

  public static void main(String[] args) {

    /**
     * 任务1：洗水壶->烧开水
     */
    CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
      System.out.println("T1:洗水壶...");
      sleep(1, TimeUnit.SECONDS);

      System.out.println("T1:烧开水...");
      sleep(15, TimeUnit.SECONDS);
    });

    /**
     * 任务2：洗茶壶->洗茶杯->拿茶叶
     */
    CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
      System.out.println("T2:洗茶壶...");
      sleep(1, TimeUnit.SECONDS);

      System.out.println("T2:洗茶杯...");
      sleep(2, TimeUnit.SECONDS);

      System.out.println("T2:拿茶叶...");
      sleep(1, TimeUnit.SECONDS);
      return "龙井";
    });

    /**
     * 任务3：任务1和任务2完成后执行：泡茶
     */
    CompletableFuture<String> f3 = f1.thenCombine(f2, (Void,tf) -> {
      System.out.println("T1:拿到茶叶:" + tf);
      System.out.println("T1:泡茶...");
      return "上茶:" + tf;
    });

    /**
     * 等待任务3 执行结果
     */
    System.out.println(f3.join());
  }

  public static void sleep(int t, TimeUnit u) {
    try {
      u.sleep(t);
    } catch (InterruptedException e) {
    }
  }
}
