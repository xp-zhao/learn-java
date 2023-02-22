package org.learn.spring.v10.bean;

import lombok.extern.slf4j.Slf4j;
import org.learn.spring.context.ApplicationListener;
import org.learn.spring.context.event.ContextClosedEvent;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
@Slf4j
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
  @Override
  public void onApplicationEvent(ContextClosedEvent event) {
    log.info("关闭事件: {}", this.getClass().getName());
  }
}
