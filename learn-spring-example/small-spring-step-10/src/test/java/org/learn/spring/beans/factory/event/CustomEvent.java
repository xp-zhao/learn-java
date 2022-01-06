package org.learn.spring.beans.factory.event;

import org.learn.spring.context.ApplicationEvent;

/**
 * @author zhaoxiaoping
 * @date 2022-1-6
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
