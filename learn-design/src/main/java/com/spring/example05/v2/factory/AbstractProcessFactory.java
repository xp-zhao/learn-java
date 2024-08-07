package com.spring.example05.v2.factory;

import com.spring.example05.v2.Task;
import com.spring.example05.v2.common.ResultEnum;
import com.spring.example05.v2.common.TaskConfig;
import com.spring.example05.v2.context.BaseProcessContext;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

/**
 * 抽象流程执行工厂
 *
 * @author zhaoxiaoping
 * @date 2024-8-6
 */
@Slf4j
public abstract class AbstractProcessFactory<T extends BaseProcessContext> {
  @Resource(name = "processMap")
  private Map<String, List<Task<T>>> processMap;

  /**
   * 执行指定流程
   *
   * @param context 上下文
   * @param processName 流程名称
   * @return 执行结果
   */
  public T execute(T context, String processName) {
    List<Task<T>> taskChains = processMap.get(processName);
    if (CollectionUtils.isEmpty(taskChains)) {
      log.error("ProcessFactory execute error taskChains is null, processName:{}", processName);
      return null;
    }

    log.info("ProcessFactory execute, processName:{}, taskChains:{}", processName, taskChains);
    // 任务增强, 增加任务前置校验与后置通知逻辑
    List<Task<T>> enhancedTaskList =
        taskChains.stream().map(this::enhanceTask).collect(Collectors.toList());

    // 获取执行结果
    return getProcessResult(context, enhancedTaskList).orElse(context);
  }

  /**
   * 流程执行器
   *
   * @param context 上下文
   * @param taskList 当前流程的任务列表
   * @return 执行结果
   */
  private Optional<T> getProcessResult(T context, List<Task<T>> taskList) {
    if (CollectionUtils.isEmpty(taskList) || Objects.isNull(context)) {
      return Optional.empty();
    }
    // 顺序执行每一个 task
    for (Task<T> f : taskList) {
      // 一些特殊ResultEnum处理，例如SKIP_ALL，直接跳过所有的流程，立即结束
      if (context.getResult() != null && context.getResult().equals(ResultEnum.SKIP_ALL)) {
        break;
      }
      context = f.execute(context);
    }

    return Optional.ofNullable(context);
  }

  /**
   * 增强任务
   *
   * @param task 当前任务
   * @return 增强后的新任务
   */
  private Task<T> enhanceTask(Task<T> task) {
    return req -> {
      TaskConfig annotation = task.getClass().getAnnotation(TaskConfig.class);
      String taskName = annotation.name();
      // 用于业务自定义的前置检查逻辑
      if (!preContextCheck(taskName, req)) {
        return null;
      }
      // 正式执行
      T result = task.execute(req);

      // 用于业务自定义的后置通知
      afterResult(taskName, result);
      return result;
    };
  }

  /**
   * 前置通知
   *
   * @param taskName 任务名
   * @param context 上下文
   * @return 是否通过
   */
  protected boolean preContextCheck(String taskName, T context) {
    if (context == null) {
      log.error("ProcessFactory.execute [{}] error, context is null", taskName);
      return false;
    }
    if (context.getResult() != null && ResultEnum.FAIL.equals(context.getResult())) {
      log.error(
          "UserRightsPipelineFactory.execute [{}] error, pre method is failed with resultEnum:{}",
          taskName,
          context.getResult());
      return false;
    }
    log.info("ProcessFactory.execute [{}] start, context:{}", taskName, context);
    return true;
  }

  /**
   * 后置通知
   *
   * @param taskName 任务名
   * @param context 上下文
   */
  protected void afterResult(String taskName, T context) {
    log.info("ProcessFactory.execute [{}] end, context:{}", taskName, context);
  }
}
