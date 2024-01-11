package com.xp.state.v4.status.handle;

import com.xp.state.v4.Task;
import com.xp.state.v4.engine.StatusMachineEngine;
import com.xp.state.v4.status.machine.factory.StatusMachineFactory;

/**
 * 状态处理器抽象类
 *
 * @author zhaoxiaoping
 * @date 2024-1-10
 */
public abstract class AbstractStatusHandler implements IStatusHandler {
  protected void before(Task task) {}

  public void handle(Task task) {
    before(task);
    doHandler(task);
    after(task);
  }

  protected abstract void doHandler(Task task);

  protected void after(Task task) {
    goNextStatusHandler(task);
  }

  protected void goNextStatusHandler(Task task) {
    // 获取下一个状态
    task.setStatus(
        StatusMachineFactory.getStatusMachine(task.getTaskType())
            .getNextStatus(task.getStatus(), task.getEvent()));
    // 状态机引擎去处理任务
    StatusMachineEngine.post(task);
  }
}
