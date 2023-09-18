package parallel.v3;

import cn.hutool.core.collection.CollUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;
import parallel.v3.dto.BaseDTO;
import parallel.v3.dto.UserAddressDTO;
import parallel.v3.dto.UserBaseDTO;
import parallel.v3.dto.UserLabelDTO;
import parallel.v3.param.AddressParam;
import parallel.v3.param.BaseParam;
import parallel.v3.param.LabelParam;
import parallel.v3.service.AddressService;
import parallel.v3.service.LabelService;
import parallel.v3.service.ParallelInvokeCommonService;
import parallel.v3.service.UserService;
import parallel.v3.task.BaseTaskCommand;
import parallel.v3.task.TaskFactory;

/**
 * 抽取通用的并行调用方法
 *
 * @author zhaoxiaoping
 * @date 2023-9-18
 */
@Slf4j
public class Client {
  private final UserService userService = new UserService();
  private final LabelService labelService = new LabelService();
  private final AddressService addressService = new AddressService();
  private final TaskFactory taskFactory = new TaskFactory();
  private final ParallelInvokeCommonService parallelInvokeCommonService =
      new ParallelInvokeCommonService();

  public UserResponse queryUser(UserRequest req) throws InterruptedException {
    List<Callable<BaseDTO<Object>>> taskList = new ArrayList<>();
    // 查询用户基本信息的任务
    taskList.add(new BaseTaskCommand("baseDTO", req, taskFactory));
    // 查询用户标签信息的任务
    taskList.add(new BaseTaskCommand("labelDTO", req, taskFactory));
    // 查询用户地址信息的任务
    taskList.add(new BaseTaskCommand("addressDTO", req, taskFactory));
    // 执行任务
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    List<BaseDTO<Object>> resultList =
        parallelInvokeCommonService.executeTask(taskList, 3, executorService);
    if (CollUtil.isEmpty(resultList)) {
      return new UserResponse();
    }
    // 获取结果
    UserBaseDTO userBaseDTO = null;
    UserLabelDTO userLabelDTO = null;
    UserAddressDTO userAddressDTO = null;

    // 提交了三个任务，获取三次结果
    for (int i = 0; i < resultList.size(); i++) {
      BaseDTO<Object> baseDTO = resultList.get(i);
      if ("baseDTO".equals(baseDTO.getKey())) {
        userBaseDTO = (UserBaseDTO) baseDTO.getData();
      } else if ("labelDTO".equals(baseDTO.getKey())) {
        userLabelDTO = (UserLabelDTO) baseDTO.getData();
      } else if ("addressDTO".equals(baseDTO.getKey())) {
        userAddressDTO = (UserAddressDTO) baseDTO.getData();
      }
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
}
