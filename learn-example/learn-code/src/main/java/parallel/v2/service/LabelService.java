package parallel.v2.service;

import java.util.concurrent.TimeUnit;
import parallel.v2.dto.UserLabelDTO;
import parallel.v2.param.LabelParam;

/**
 * @author zhaoxiaoping
 * @date 2023-9-18
 */
public class LabelService {
  public UserLabelDTO queryLabelInfo(LabelParam param) throws InterruptedException {
    TimeUnit.MILLISECONDS.sleep(100);
    return new UserLabelDTO();
  }
}
