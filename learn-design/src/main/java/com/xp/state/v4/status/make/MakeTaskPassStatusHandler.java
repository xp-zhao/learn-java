package com.xp.state.v4.status.make;

import com.xp.state.v4.Task;
import com.xp.state.v4.status.handle.AbstractStatusHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * 制作任务成功状态处理器
 *
 * @author zhaoxiaoping
 * @date 2024-1-11
 */
@Slf4j
public class MakeTaskPassStatusHandler extends AbstractStatusHandler {
  @Override
  protected void doHandler(Task task) {
    log.info("user:{}--制作任务成功 task-status:{}", task.getUser(), task.getStatus().getCode());
  }

  @Override
  protected void after(Task task) {}
}
