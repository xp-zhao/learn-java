package async.parallel;

import async.callback.ICallback;
import async.callback.IWorker;
import async.executor.timer.SystemClock;
import async.worker.WorkResult;

/**
 * 并行任务3
 *
 * @author zhaoxiaoping
 * @date 2023-7-1
 */
public class ParWorker3 implements IWorker<String, String>, ICallback<String, String> {
  @Override
  public void result(boolean success, String param, WorkResult<String> workResult) {
    if (success) {
      System.out.println(
          "callback worker3 success--"
              + SystemClock.now()
              + "----"
              + workResult.getResult()
              + "-threadName:"
              + Thread.currentThread().getName());
    } else {
      System.err.println(
          "callback worker3 failure--"
              + SystemClock.now()
              + "----"
              + workResult.getResult()
              + "-threadName:"
              + Thread.currentThread().getName());
    }
  }

  @Override
  public String action(String object) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "result = " + SystemClock.now() + "---param = " + object + " from worker3";
  }

  @Override
  public String defaultValue() {
    return "worker3-default";
  }
}
