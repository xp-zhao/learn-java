package org.learn.spring.beans.factory.event;

import org.learn.spring.context.ApplicationListener;
import org.learn.spring.context.event.ContextRefreshedEvent;

/**
 * @author zhaoxiaoping
 * @date 2022-1-6
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    System.out.println("刷新事件：" + this.getClass().getName());
  }
}
