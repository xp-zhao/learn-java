package async.seq;

import async.callback.ICallback;
import async.callback.IWorker;
import async.executor.timer.SystemClock;
import async.worker.WorkResult;
import async.wrapper.WorkerWrapper;

import java.util.Map;

/**
 * 串行任务1
 *
 * @author zhaoxiaoping
 * @date 2023-7-1
 */
public class SeqWorker1 implements IWorker<String, String>, ICallback<String, String> {
  @Override
  public void result(boolean success, String param, WorkResult<String> workResult) {
    if (success) {
      System.out.println(
          "callback worker1 success--"
              + SystemClock.now()
              + "----"
              + workResult.getResult()
              + "-threadName:"
              + Thread.currentThread().getName());
    } else {
      System.err.println(
          "callback worker1 failure--"
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
    return "result = " + SystemClock.now() + "---param = " + object + " from worker1";
  }

  @Override
  public String defaultValue() {
    return "worker1-default";
  }
}
