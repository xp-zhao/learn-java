package parallel.v3.service;

import java.util.concurrent.TimeUnit;
import parallel.v3.UserRequest;
import parallel.v3.dto.UserLabelDTO;
import parallel.v3.param.LabelParam;

/**
 * @author zhaoxiaoping
 * @date 2023-9-18
 */
public class LabelService {

  public LabelParam buildLabelParam(UserRequest req) {
    return new LabelParam();
  }

  public UserLabelDTO queryLabelInfo(LabelParam param) throws InterruptedException {
    TimeUnit.MILLISECONDS.sleep(100);
    return new UserLabelDTO();
  }
}
