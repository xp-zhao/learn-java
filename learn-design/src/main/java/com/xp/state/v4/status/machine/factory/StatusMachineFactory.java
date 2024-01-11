package com.xp.state.v4.status.machine.factory;

import com.xp.state.v4.common.TaskType;
import com.xp.state.v4.status.machine.IStatusMachine;
import com.xp.state.v4.status.machine.MakeTaskStatusMachine;
import com.xp.state.v4.status.machine.ReviewTaskStatusMachine;

/**
 * 状态机工厂
 *
 * @author zhaoxiaoping
 * @date 2024-1-10
 */
public class StatusMachineFactory {
  private StatusMachineFactory() {}

  /**
   * 根据状态获取状态机
   *
   * @param taskType
   * @return 对应任务类型的状态机
   */
  public static IStatusMachine getStatusMachine(TaskType taskType) {
    switch (taskType) {
      case REVIEW_TASK:
        return new ReviewTaskStatusMachine();
      case MAKE_TASK:
        return new MakeTaskStatusMachine();
      default:
        throw new RuntimeException("未知类型");
    }
  }
}
