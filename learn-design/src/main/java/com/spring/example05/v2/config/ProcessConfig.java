package com.spring.example05.v2.config;

import com.spring.example05.v2.Task;
import com.spring.example05.v2.common.TaskConfig;
import com.spring.example05.v2.context.BaseProcessContext;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 流程配置
 *
 * @author zhaoxiaoping
 * @date 2024-8-7
 */
@Configuration
public class ProcessConfig<T extends BaseProcessContext> {
  /** 任务信息 */
  private final Map<String, Task<T>> taskMap = new ConcurrentHashMap<>();

  @Autowired private ApplicationContext context;

  /** 初始化任务信息 */
  @PostConstruct
  private void initTaskMap() {
    Map<String, Object> beansWithAnnotation = context.getBeansWithAnnotation(TaskConfig.class);
    for (Object bean : beansWithAnnotation.values()) {
      if (bean instanceof Task) {
        TaskConfig annotation = bean.getClass().getAnnotation(TaskConfig.class);
        taskMap.put(annotation.name(), (Task<T>) bean);
      }
    }
  }

  /** 初始化流程 map */
  @Bean(name = "processMap")
  public Map<String, List<Task<T>>> initProcessMap(ApplicationContext applicationContext) {
    Map<String, List<Task<T>>> processMap = new ConcurrentHashMap<>();
    // 获取不同流程的任务配置
    Map<String, List<String>> processTaskChain = ProcessTaskConfig.taskChainConfig;
    for (String processName : processTaskChain.keySet()) {
      // 任务名称列表
      List<String> taskNameList = processTaskChain.get(processName);
      List<Task<T>> taskChains =
          taskNameList.stream().map(taskMap::get).collect(Collectors.toList());
      processMap.put(processName, taskChains);
    }
    return processMap;
  }
}
