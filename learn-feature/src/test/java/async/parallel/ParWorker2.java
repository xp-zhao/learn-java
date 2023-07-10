package async.parallel;

import async.callback.ICallback;
import async.callback.IWorker;
import async.executor.timer.SystemClock;
import async.worker.WorkResult;
import async.wrapper.WorkerWrapper;

import java.util.Map;

/**
 * 并行任务2
 *
 * @author zhaoxiaoping
 * @date 2023-7-1
 */
public class ParWorker2 implements IWorker<String, String>, ICallback<String, String> {
  @Override
  public void result(boolean success, String param, WorkResult<String> workResult) {
    if (success) {
      System.out.println(
          "callback worker2 success--"
              + SystemClock.now()
              + "----"
              + workResult.getResult()
              + "-threadName:"
              + Thread.currentThread().getName());
    } else {
      System.err.println(
          "callback worker2 failure--"
              + SystemClock.now()
              + "----"
              + workResult.getResult()
              + "-threadName:"
              + Thread.currentThread().getName());
    }
  }

  @Override
  public String action(String object, Map<String, WorkerWrapper> allWrapper) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "result = " + SystemClock.now() + "---param = " + object + " from worker2";
  }

  @Override
  public String defaultValue() {
    return "worker2-default";
  }
}
