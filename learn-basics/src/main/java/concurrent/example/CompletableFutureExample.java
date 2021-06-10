package concurrent.example;

import cn.hutool.core.date.StopWatch;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description: CompletableFuture 使用示例
 * @Date 2021-6-10
 **/
@Slf4j
public class CompletableFutureExample {

  public static void main(String[] args) throws Exception {
    CompletableFutureExample example = new CompletableFutureExample();
    example.serialCall();
    example.futureCall();
    example.completableFutureCall();
  }

  private void serialCall() {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start("同步调用");
    String userInfo = UserInfoService.getUserInfo();
    log.info(userInfo);
    // 模拟主线程耗时操作
    sleep();
    String userOrderInfo = UserOrderService.getUserOrderInfo();
    log.info(userOrderInfo);
    stopWatch.stop();
    log.info("{} 耗时 {} 毫秒", stopWatch.getLastTaskName(), stopWatch.getTotalTimeMillis());
  }

  private void futureCall() throws ExecutionException, InterruptedException {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start("异步调用");
    ExecutorService threadPool = Executors.newFixedThreadPool(10);
    FutureTask<String> userFutureTask = new FutureTask<>(UserInfoService::getUserInfo);
    threadPool.submit(userFutureTask);
    // 模拟主线程耗时操作
    sleep();
    FutureTask<String> orderFutureTask = new FutureTask<>(UserOrderService::getUserOrderInfo);
    threadPool.submit(orderFutureTask);
    log.info(userFutureTask.get());
    log.info(orderFutureTask.get());
    threadPool.shutdown();
    stopWatch.stop();
    log.info("{} 耗时 {} 毫秒", stopWatch.getLastTaskName(), stopWatch.getTotalTimeMillis());
  }

  private void completableFutureCall() throws Exception {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start("CompletableFuture 调用");
    CompletableFuture<String> user = CompletableFuture
        .supplyAsync(UserInfoService::getUserInfo);
    // 模拟主线程耗时操作
    sleep();
    CompletableFuture<String> order = CompletableFuture
        .supplyAsync(UserOrderService::getUserOrderInfo);
    log.info(user.get(1, TimeUnit.SECONDS));
    log.info(order.get(1, TimeUnit.SECONDS));
    stopWatch.stop();
    log.info("{} 耗时 {} 毫秒", stopWatch.getLastTaskName(), stopWatch.getTotalTimeMillis());
  }

  private void sleep() {
    try {
      TimeUnit.MILLISECONDS.sleep(300);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class UserInfoService {

  public static String getUserInfo() {
    try {
      // 模拟耗时操作
      TimeUnit.MILLISECONDS.sleep(300);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "用户基本信息";
  }
}

class UserOrderService {

  public static String getUserOrderInfo() {
    try {
      // 模拟耗时操作
      TimeUnit.MILLISECONDS.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "用户订单信息";
  }
}