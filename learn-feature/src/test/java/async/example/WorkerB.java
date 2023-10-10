package async.example;

import async.callback.ICallback;
import async.callback.IWorker;
import async.executor.timer.SystemClock;
import async.worker.WorkResult;
import async.wrapper.WorkerWrapper;
import cn.hutool.json.JSONUtil;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-10-10
 */
@Slf4j
public class WorkerB implements IWorker<Integer, Integer>, ICallback<Integer, Integer> {
  /** worker 开始的时候先执行 begin */
  @Override
  public void begin() {
    log.info("B-Thread: {}, start: {}", Thread.currentThread().getName(), SystemClock.now());
  }

  @Override
  public void result(boolean success, Integer param, WorkResult<Integer> workResult) {
    log.info("B-param: {}", param);
    log.info("B-result: {}", JSONUtil.toJsonStr(workResult));
    log.info("B-Thread: {}, end: {}", Thread.currentThread().getName(), SystemClock.now());
  }

  /**
   * 耗时操作
   *
   * @param object object
   * @param allWrapper
   * @return
   */
  @Override
  public Integer action(Integer object, Map<String, WorkerWrapper> allWrapper) {
    return object + 2;
  }

  /**
   * 异常时返回的默认值
   *
   * @return
   */
  @Override
  public Integer defaultValue() {
    log.info("B-defaultValue");
    return 102;
  }
}
