package parallel.v1;

import cn.hutool.core.date.StopWatch;
import lombok.extern.slf4j.Slf4j;
import parallel.v1.dto.UserAddressDTO;
import parallel.v1.dto.UserBaseDTO;
import parallel.v1.dto.UserLabelDTO;
import parallel.v1.param.AddressParam;
import parallel.v1.param.BaseParam;
import parallel.v1.param.LabelParam;
import parallel.v1.service.AddressService;
import parallel.v1.service.LabelService;
import parallel.v1.service.UserService;

/**
 * 模拟业务流程，串行调用多个服务查询用户信息
 *
 * @author zhaoxiaoping
 * @date 2023-9-18
 */
@Slf4j
public class Client {
  private final UserService userService = new UserService();
  private final LabelService labelService = new LabelService();
  private final AddressService addressService = new AddressService();

  public UserResponse queryUser(UserRequest req) throws InterruptedException {
    // 查询用户基本信息
    BaseParam baseParam = buildBaseParam(req);
    UserBaseDTO userBaseDTO = userService.queryUserInfo(baseParam);
    // 查询用户标签信息
    LabelParam labelParam = buildLabelParam(req);
    UserLabelDTO userLabelDTO = labelService.queryLabelInfo(labelParam);
    // 查询用户地址信息
    AddressParam addressParam = buildAddressParam(req);
    UserAddressDTO userAddressDTO = addressService.queryAddressInfo(addressParam);
    return buildResponse(userBaseDTO, userLabelDTO, userAddressDTO);
  }

  private BaseParam buildBaseParam(UserRequest req) {
    return new BaseParam();
  }

  private LabelParam buildLabelParam(UserRequest req) {
    return new LabelParam();
  }

  private AddressParam buildAddressParam(UserRequest req) {
    return new AddressParam();
  }

  private UserResponse buildResponse(
      UserBaseDTO baseDto, UserLabelDTO labelDto, UserAddressDTO addressDto) {
    return new UserResponse();
  }

  public static void main(String[] args) throws InterruptedException {
    Client client = new Client();
    StopWatch watch = new StopWatch();
    watch.start();
    UserResponse userResponse = client.queryUser(new UserRequest());
    watch.stop();
    log.info("查询耗时：{}ms", watch.getTotalTimeMillis());
  }
}
