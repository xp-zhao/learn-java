package async.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author zhaoxiaoping
 * @date 2023-6-16
 */
public class BootstrapNew {
  public static void main(String[] args) {
    BootstrapNew bootstrap = new BootstrapNew();
    Worker worker = bootstrap.newWorker();
    Wrapper wrapper = new Wrapper();
    wrapper.setWorker(worker);
    wrapper.setParam("hello");
    wrapper.addListener(
        new Listener() {
          @Override
          public void result(Object result) {
            System.out.println(result);
          }
        });
    CompletableFuture<String> future =
        CompletableFuture.supplyAsync(
            () -> {
              try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
              return "";
            });
    try {
      future.get(800, TimeUnit.MILLISECONDS);
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
      wrapper.getListener().result("time out exception");
    }
    System.out.println(Thread.currentThread().getName());
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
