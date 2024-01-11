package com.xp.state.v4.status.handle;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import com.xp.state.v4.StatusHandlerRegistry;
import com.xp.state.v4.Task;

/**
 * 任务处理器
 *
 * @author zhaoxiaoping
 * @date 2024-1-11
 */
public class TaskHandler {
  @Subscribe
  @AllowConcurrentEvents
  public void handle(Task task) {
    // 获取到状态处理类，然后去处理 handler为StatusHandler的入口
    getStatusHandler(task).handle(task);
  }

  /**
   * 根据假单获取StatusHandler 状态处理对象
   *
   * @param task
   * @return
   */
  public static IStatusHandler getStatusHandler(Task task) {
    return StatusHandlerRegistry.acquireStatusHandler(task.getTaskType(), task.getStatus());
  }
}
