package org.learn.spring.context.event;

/**
 * 容器刷新事件
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {
  /**
   * Constructs a prototypical Event.
   *
   * @param source The object on which the Event initially occurred.
   * @throws IllegalArgumentException if source is null.
   */
  public ContextRefreshedEvent(Object source) {
    super(source);
  }
}
