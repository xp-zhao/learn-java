package com.xp.state.v4.status.handle;

import com.xp.state.v4.Task;

/**
 * 状态处理器
 *
 * @author zhaoxiaoping
 * @date 2024-1-10
 */
public interface IStatusHandler {
  void handle(Task task);
}
