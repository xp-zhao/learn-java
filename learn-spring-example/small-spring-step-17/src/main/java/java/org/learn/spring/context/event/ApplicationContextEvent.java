package java.org.learn.spring.context.event;

import org.learn.spring.context.ApplicationContext;
import org.learn.spring.context.ApplicationEvent;

/**
 * @author zhaoxiaoping
 * @date 2022-1-6
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
