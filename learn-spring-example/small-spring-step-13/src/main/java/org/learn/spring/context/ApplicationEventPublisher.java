package org.learn.spring.context;

/**
 * 事件发布者接口
 *
 * @author zhaoxiaoping
 * @date 2022-1-6
 */
public interface ApplicationEventPublisher {
  /**
   * 发布事件
   *
   * @param event 事件
   */
  void publishEvent(ApplicationEvent event);
}
