package parallel.v3.service;

import java.util.concurrent.TimeUnit;
import parallel.v3.UserRequest;
import parallel.v3.dto.UserBaseDTO;
import parallel.v3.param.BaseParam;

/**
 * @author zhaoxiaoping
 * @date 2023-9-18
 */
public class UserService {

  public BaseParam buildBaseParam(UserRequest req) {
    return new BaseParam();
  }

  public UserBaseDTO queryUserInfo(BaseParam param) throws InterruptedException {
    TimeUnit.MILLISECONDS.sleep(100);
    return new UserBaseDTO();
  }
}
