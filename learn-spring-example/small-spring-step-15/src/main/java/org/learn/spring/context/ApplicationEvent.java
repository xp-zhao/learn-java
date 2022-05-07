package org.learn.spring.context;

import java.util.EventObject;

/**
 * 具备事件功能的抽象类
 *
 * @author zhaoxiaoping
 * @date 2022-1-6
 */
public abstract class ApplicationEvent extends EventObject {

  /**
   * Constructs a prototypical Event.
   *
   * @param source The object on which the Event initially occurred.
   * @throws IllegalArgumentException if source is null.
   */
  public ApplicationEvent(Object source) {
    super(source);
  }
}
