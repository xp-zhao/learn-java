package parallel.v3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import parallel.v3.dto.BaseDTO;

/**
 * @author zhaoxiaoping
 * @date 2023-9-18
 */
public class ParallelInvokeCommonService {
  public List<BaseDTO<Object>> executeTask(
      List<Callable<BaseDTO<Object>>> taskList, long timeOut, ExecutorService executorService) {
    List<BaseDTO<Object>> resultList = new ArrayList<>();
    if (taskList == null || taskList.size() == 0) {
      return resultList;
    }
    if (executorService == null || timeOut <= 0) {
      return resultList;
    }
    // 提交任务
    CompletionService<BaseDTO<Object>> completionService =
        new ExecutorCompletionService<BaseDTO<Object>>(executorService);
    for (Callable<BaseDTO<Object>> task : taskList) {
      completionService.submit(task);
    }
    try {
      // 遍历获取结果
      for (int i = 0; i < taskList.size(); i++) {
        Future<BaseDTO<Object>> future = completionService.poll(timeOut, TimeUnit.SECONDS);
        resultList.add(future.get());
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      throw new RuntimeException(e);
    }
    return resultList;
  }
}
