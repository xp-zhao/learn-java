package org.learn.spring.context.event;

import org.learn.spring.beans.factory.BeanFactory;
import org.learn.spring.context.ApplicationEvent;
import org.learn.spring.context.ApplicationListener;

/**
 * 事件广播器实现
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

  public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
    setBeanFactory(beanFactory);
  }

  @Override
  public void multicastEvent(ApplicationEvent event) {
    for (final ApplicationListener listener : getApplicationListeners(event)) {
      listener.onApplicationEvent(event);
    }
  }
}
