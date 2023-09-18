package parallel.v3.task;

import parallel.v3.UserRequest;
import parallel.v3.dto.BaseDTO;

/**
 * @author zhaoxiaoping
 * @date 2023-9-18
 */
public interface IBaseTask {
  /**
   * 每个查询的 key, 标识当前查询的内容
   *
   * @return
   */
  String getTaskKey();

  BaseDTO<Object> execute(UserRequest req) throws InterruptedException;
}
