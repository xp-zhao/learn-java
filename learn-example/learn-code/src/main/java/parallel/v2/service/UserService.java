package parallel.v2.service;

import java.util.concurrent.TimeUnit;
import parallel.v2.dto.UserBaseDTO;
import parallel.v2.param.BaseParam;

/**
 * @author zhaoxiaoping
 * @date 2023-9-18
 */
public class UserService {
  public UserBaseDTO queryUserInfo(BaseParam param) throws InterruptedException {
    TimeUnit.MILLISECONDS.sleep(100);
    return new UserBaseDTO();
  }
}
