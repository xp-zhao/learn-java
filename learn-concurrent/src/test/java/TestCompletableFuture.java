import java.util.concurrent.CompletableFuture;

/**
 * @author zhaoxiaoping
 * @Description: CompletableFuture测试
 * @Date 2020/4/17
 **/
public class TestCompletableFuture {

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
