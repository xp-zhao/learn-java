package async.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import lombok.extern.slf4j.Slf4j;

/**
 * 一个带有超时的简单回调异步任务
 *
 * @author zhaoxiaoping
 * @date 2023-6-16
 */
@Slf4j
public class BootstrapTimeOut {
  public static void main(String[] args) {
    BootstrapTimeOut bootstrap = new BootstrapTimeOut();
    Worker worker = bootstrap.newWorker();

    Wrapper wrapper = new Wrapper();
    wrapper.setWorker(worker);
    wrapper.setParam("hello");
    // 添加回调器
    wrapper.addListener(
        new Listener() {
          @Override
          public void result(Object result) {
            log.info("worker 回调结果：{}", result);
          }
        });
    // 主线程执行
    log.info(Thread.currentThread().getName());
    // 耗时任务执行
    CompletableFuture<Wrapper> future =
        CompletableFuture.supplyAsync(() -> bootstrap.doWork(wrapper));

    try {
      // 这里会超时，进入 catch 块中进行超时回调
      future.get(800, TimeUnit.MILLISECONDS);
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
      wrapper.getListener().result("time out exception");
    }
  }

  private Wrapper doWork(Wrapper wrapper) {
    Worker worker = wrapper.getWorker();
    String result = worker.action(wrapper.getParam());
    wrapper.getListener().result(result);
    return wrapper;
  }

  private Worker newWorker() {
    return new Worker() {
      @Override
      public String action(Object object) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        return object + " world";
      }
    };
  }
}
