package parallel.v3.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import parallel.v3.UserRequest;
import parallel.v3.dto.BaseDTO;
import parallel.v3.dto.UserBaseDTO;
import parallel.v3.param.BaseParam;
import parallel.v3.service.UserService;

/**
 * @author zhaoxiaoping
 * @date 2023-9-18
 */
@Service
@RequiredArgsConstructor
public class UserTask implements IBaseTask {

  private final UserService userService;

  @Override
  public String getTaskKey() {
    return "baseDTO";
  }

  @Override
  public BaseDTO<Object> execute(UserRequest req) throws InterruptedException {
    BaseParam baseParam = userService.buildBaseParam(req);
    UserBaseDTO userBaseDTO = userService.queryUserInfo(baseParam);
    return new BaseDTO<>(getTaskKey(), userBaseDTO);
  }
}
