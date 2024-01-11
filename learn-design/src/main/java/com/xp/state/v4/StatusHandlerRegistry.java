package com.xp.state.v4;

import com.xp.state.v4.common.TaskType;
import com.xp.state.v4.status.Status;
import com.xp.state.v4.status.handle.IStatusHandler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 状态处理注册器
 *
 * @author zhaoxiaoping
 * @date 2024-1-11
 */
public class StatusHandlerRegistry {
  private static Map<String, IStatusHandler> statusHandlerMap = new ConcurrentHashMap<>();

  private StatusHandlerRegistry() {}

  private static String getKey(TaskType taskType, Status status) {
    return String.format("%s@-@%s", taskType.getCode(), status.name());
  }

  /**
   * 注册状态处理类
   *
   * @param taskType 任务类型
   * @param status 任务状态
   * @param statusHandler 状态处理对象
   */
  public static void registryStatusHandler(
      TaskType taskType, Status status, IStatusHandler statusHandler) {
    statusHandlerMap.put(getKey(taskType, status), statusHandler);
  }

  /**
   * 获取状态处理类
   *
   * @param taskType 任务类型
   * @param status 任务状态
   * @return StatusHandler
   */
  public static IStatusHandler acquireStatusHandler(TaskType taskType, Status status) {
    return statusHandlerMap.get(getKey(taskType, status));
  }
}
