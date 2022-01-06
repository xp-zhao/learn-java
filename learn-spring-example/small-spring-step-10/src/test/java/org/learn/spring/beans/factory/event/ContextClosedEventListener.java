package org.learn.spring.beans.factory.event;

import org.learn.spring.context.ApplicationListener;
import org.learn.spring.context.event.ContextClosedEvent;

/**
 * @author zhaoxiaoping
 * @date 2022-1-6
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

  @Override
  public void onApplicationEvent(ContextClosedEvent event) {
    System.out.println("关闭事件：" + this.getClass().getName());
  }
}
