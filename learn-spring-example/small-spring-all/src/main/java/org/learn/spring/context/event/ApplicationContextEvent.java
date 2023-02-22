package org.learn.spring.context.event;

import org.learn.spring.context.ApplicationContext;
import org.learn.spring.context.ApplicationEvent;

/**
 * 容器事件
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
public class ApplicationContextEvent extends ApplicationEvent {
  /**
   * Constructs a prototypical Event.
   *
   * @param source The object on which the Event initially occurred.
   * @throws IllegalArgumentException if source is null.
   */
  public ApplicationContextEvent(Object source) {
    super(source);
  }

  public final ApplicationContext getApplicationContext() {
    return (ApplicationContext) getSource();
  }
}
