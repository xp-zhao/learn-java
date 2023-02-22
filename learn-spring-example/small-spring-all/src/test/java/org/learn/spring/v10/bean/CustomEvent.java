package org.learn.spring.v10.bean;

import org.learn.spring.context.ApplicationEvent;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
public class CustomEvent extends ApplicationEvent {

  private Long id;
  private String message;

  /**
   * Constructs a prototypical Event.
   *
   * @param source The object on which the Event initially occurred.
   * @throws IllegalArgumentException if source is null.
   */
  public CustomEvent(Object source, Long id, String message) {
    super(source);
    this.id = id;
    this.message = message;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
