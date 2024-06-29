package org.learn.flowable.task;

/**
 * 任务数据处理接口
 *
 * @author zhaoxiaoping
 * @date 2024-6-25
 */
public interface TaskDataProcessor {
  /** 初始化流程数据 */
  void initProcessData();

  /** 流程结束时调用 */
  void processEnd();
}
