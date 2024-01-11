package com.xp.state.v4.engine;

import com.google.common.eventbus.EventBus;
import com.xp.state.v4.Task;
import com.xp.state.v4.status.handle.TaskHandler;

/**
 * 状态机引擎
 *
 * @author zhaoxiaoping
 * @date 2024-1-10
 */
public class StatusMachineEngine {
  private static EventBus eventBus;

  static {
    eventBus = new EventBus();
  }

  /**
   * 提交任务
   *
   * @param task
   */
  public static void post(Task task) {
    eventBus.post(task);
  }

  /**
   * 任务处理类
   *
   * @param statusTaskHandler
   */
  public static void addListener(TaskHandler statusTaskHandler) {
    eventBus.register(statusTaskHandler);
  }
}
