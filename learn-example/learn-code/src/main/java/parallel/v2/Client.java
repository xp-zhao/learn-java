package parallel.v2;

import cn.hutool.core.date.StopWatch;
import java.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;
import parallel.v2.dto.BaseDTO;
import parallel.v2.dto.UserAddressDTO;
import parallel.v2.dto.UserBaseDTO;
import parallel.v2.dto.UserLabelDTO;
import parallel.v2.param.AddressParam;
import parallel.v2.param.BaseParam;
import parallel.v2.param.LabelParam;
import parallel.v2.service.AddressService;
import parallel.v2.service.LabelService;
import parallel.v2.service.UserService;

/**
 * 使用CompletionService实现并行调用
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
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    CompletionService<BaseDTO<Object>> userCompletionService =
        new ExecutorCompletionService<>(executorService);
    // 查询用户基本信息的任务
    Callable<BaseDTO<Object>> userBaseDTOCallable =
        () -> {
          BaseParam baseParam = buildBaseParam(req);
          UserBaseDTO userBaseDTO = userService.queryUserInfo(baseParam);
          return new BaseDTO<>("baseDTO", userBaseDTO);
        };
    // 查询用户标签信息的任务
    Callable<BaseDTO<Object>> userLabelDTOCallable =
        () -> {
          LabelParam labelParam = buildLabelParam(req);
          UserLabelDTO userLabelDTO = labelService.queryLabelInfo(labelParam);
          return new BaseDTO<>("labelDTO", userLabelDTO);
        };
    // 查询用户地址信息的任务
    Callable<BaseDTO<Object>> userAddressDTOCallable =
        () -> {
          AddressParam addressParam = buildAddressParam(req);
          UserAddressDTO userAddressDTO = addressService.queryAddressInfo(addressParam);
          return new BaseDTO<>("addressDTO", userAddressDTO);
        };
    // 提交任务
    userCompletionService.submit(userBaseDTOCallable);
    userCompletionService.submit(userLabelDTOCallable);
    userCompletionService.submit(userAddressDTOCallable);
    // 获取结果
    UserBaseDTO userBaseDTO = null;
    UserLabelDTO userLabelDTO = null;
    UserAddressDTO userAddressDTO = null;
    try {
      // 提交了三个任务，获取三次结果
      for (int i = 0; i < 3; i++) {
        Future<BaseDTO<Object>> future = userCompletionService.poll(1, TimeUnit.SECONDS);
        BaseDTO<Object> baseDTO = future.get();
        if ("baseDTO".equals(baseDTO.getKey())) {
          userBaseDTO = (UserBaseDTO) baseDTO.getData();
        } else if ("labelDTO".equals(baseDTO.getKey())) {
          userLabelDTO = (UserLabelDTO) baseDTO.getData();
        } else if ("addressDTO".equals(baseDTO.getKey())) {
          userAddressDTO = (UserAddressDTO) baseDTO.getData();
        }
      }
    } catch (ExecutionException e) {
      throw new RuntimeException(e);
    }
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
