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
public class WorkerC implements IWorker<Integer, Integer>, ICallback<Integer, Integer> {
  /** worker 开始的时候先执行 begin */
  @Override
  public void begin() {
    log.info("C-Thread: {}, start: {}", Thread.currentThread().getName(), SystemClock.now());
  }

  @Override
  public void result(boolean success, Integer param, WorkResult<Integer> workResult) {
    log.info("C-param: {}", param);
    log.info("C-result: {}", JSONUtil.toJsonStr(workResult));
    log.info("C-Thread: {}, end: {}", Thread.currentThread().getName(), SystemClock.now());
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
    return object + 3;
  }

  /**
   * 异常时返回的默认值
   *
   * @return
   */
  @Override
  public Integer defaultValue() {
    log.info("C-defaultValue");
    return 103;
  }
}
