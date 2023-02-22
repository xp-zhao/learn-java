package org.learn.spring.context.event;

import org.learn.spring.context.ApplicationEvent;
import org.learn.spring.context.ApplicationListener;

/**
 * 事件广播器接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
public interface ApplicationEventMulticaster {
  /**
   * 添加监听器, 用于接收所有事件的通知
   *
   * @param listener
   */
  void addApplicationListener(ApplicationListener<?> listener);

  /**
   * 删除监听器
   *
   * @param listener
   */
  void removeApplicationListener(ApplicationListener<?> listener);

  /**
   * 广播事件到监听器
   *
   * @param event
   */
  void multicastEvent(ApplicationEvent event);
}
