package org.learn.spring.context.event;

import org.learn.spring.context.ApplicationEvent;
import org.learn.spring.context.ApplicationListener;

/**
 * 事件广播器
 *
 * @author zhaoxiaoping
 * @date 2022-1-6
 */
public interface ApplicationEventMulticaster {
  /**
   * Add a listener to be notified of all events.
   *
   * @param listener the listener to add
   */
  void addApplicationListener(ApplicationListener<?> listener);

  /**
   * Remove a listener from the notification list.
   *
   * @param listener the listener to remove
   */
  void removeApplicationListener(ApplicationListener<?> listener);

  /**
   * Multicast the given application event to appropriate listeners.
   *
   * @param event the event to multicast
   */
  void multicastEvent(ApplicationEvent event);
}
