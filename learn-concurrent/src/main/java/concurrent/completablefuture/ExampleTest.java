package concurrent.completablefuture;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/6/25
 */
@SuppressWarnings("AlibabaThreadPoolCreation")
public class ExampleTest {
  /** step1、step2、step3存在依赖关系，其中step3的执行依赖step1和step2的结果 */
  @Test
  public void testThenCombine() {
    ExecutorService executor = Executors.newFixedThreadPool(5);
    CompletableFuture<String> cf1 =
        CompletableFuture.supplyAsync(
            () -> {
              System.out.println("执行 step1");
              return "step1 result";
            },
            executor);
    CompletableFuture<String> cf2 =
        CompletableFuture.supplyAsync(
            () -> {
              System.out.println("执行 step2");
              return "step2 result";
            });
    cf1.thenCombine(
            cf2,
            (r1, r2) -> {
              System.out.println(r1 + " , " + r2);
              System.out.println("执行 step3");
              return "step3 result";
            })
        .thenAccept(r3 -> System.out.println(r3));
  }

  /**
   * 测试复杂业务 <br>
   * 零依赖：cf1, cf2 <br>
   * 一元依赖：cf3 依赖 cf1 的结果， cf5 依赖 cf2 的结果<br>
   * 二元依赖：cf4 依赖 cf1, cf2 的结果<br>
   * 多元依赖：cf6 依赖 cf3, cf4, cf5 的结果<br>
   */
  @Test
  public void testComplexBusiness() {
    ExecutorService executor = Executors.newFixedThreadPool(5);
    // 1、使用runAsync或supplyAsync发起异步调用
    CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> "result1", executor);
    // 2、CompletableFuture.completedFuture()直接创建一个已完成状态的CompletableFuture
    CompletableFuture<String> cf2 = CompletableFuture.completedFuture("result2");
    // 3、先初始化一个未完成的CompletableFuture，然后通过complete()、completeExceptionally()，完成该CompletableFuture
    CompletableFuture<String> cf = new CompletableFuture<>();
    cf.complete("success");
    // result1为CF1的结果
    CompletableFuture<String> cf3 = cf1.thenApply(result1 -> "result3");
    // result2为CF2的结果
    CompletableFuture<String> cf5 = cf2.thenApply(result2 -> "result5");
    // result1和result2分别为cf1和cf2的结果
    CompletableFuture<String> cf4 = cf1.thenCombine(cf2, (result1, result2) -> "result4");
    CompletableFuture<Void> cf6 = CompletableFuture.allOf(cf3, cf4, cf5);
    CompletableFuture<String> result =
        cf6.thenApply(
            v -> {
              // 这里的join并不会阻塞，因为传给thenApply的函数是在CF3、CF4、CF5全部完成时，才会执行 。
              String result3 = cf3.join();
              String result4 = cf4.join();
              String result5 = cf5.join();
              // 根据result3、result4、result5组装最终result;
              return "result";
            });
  }
}
