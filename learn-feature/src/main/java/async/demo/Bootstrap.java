package async.demo;

import lombok.extern.slf4j.Slf4j;

/**
 * 一个简单回调的异步任务
 *
 * @author zhaoxiaoping
 * @date 2023-6-15
 */
@Slf4j
public class Bootstrap {
  public static void main(String[] args) throws InterruptedException {
    Bootstrap bootstrap = new Bootstrap();
    Worker worker = bootstrap.newWorker();

    Wrapper wrapper = new Wrapper();
    wrapper.setWorker(worker);
    wrapper.setParam("hello");

    // 回调方法，输出 worker 中的内容
    bootstrap
        .doWork(wrapper)
        .addListener(
            new Listener() {
              @Override
              public void result(Object result) {
                log.info(Thread.currentThread().getName());
                log.info("worker 回调结果: {}", result);
              }
            });
    // 主线程不阻塞，直接打印当前线程
    log.info(Thread.currentThread().getName());
  }

  private Wrapper doWork(Wrapper wrapper) {
    new Thread(
            () -> {
              Worker worker = wrapper.getWorker();
              String result = worker.action(wrapper.getParam());
              wrapper.getListener().result(result);
            })
        .start();
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
