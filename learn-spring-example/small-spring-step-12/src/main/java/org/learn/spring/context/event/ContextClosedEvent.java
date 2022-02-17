package org.learn.spring.context.event;

/**
 * 关闭事件
 *
 * @author zhaoxiaoping
 * @date 2022-1-6
 */
public class ContextClosedEvent extends ApplicationContextEvent {

  /**
   * Constructs a prototypical Event.
   *
   * @param source The object on which the Event initially occurred.
   * @throws IllegalArgumentException if source is null.
   */
  public ContextClosedEvent(Object source) {
    super(source);
  }
}
