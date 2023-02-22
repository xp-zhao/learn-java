package org.learn.spring.context;

/**
 * 事件发布接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
public interface ApplicationEventPublisher {
  /**
   * 发布事件
   *
   * @param event
   */
  void publishEvent(ApplicationEvent event);
}
