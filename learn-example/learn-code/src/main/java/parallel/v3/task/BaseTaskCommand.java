package parallel.v3.task;

import java.util.concurrent.Callable;
import lombok.RequiredArgsConstructor;
import parallel.v3.UserRequest;
import parallel.v3.dto.BaseDTO;

/**
 * @author zhaoxiaoping
 * @date 2023-9-18
 */
@RequiredArgsConstructor
public class BaseTaskCommand implements Callable<BaseDTO<Object>> {

  private final String key;
  private final UserRequest req;
  private final TaskFactory taskFactory;

  @Override
  public BaseDTO<Object> call() throws Exception {
    return taskFactory.executeTask(key, req);
  }
}
