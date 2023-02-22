package org.learn.spring.v10.bean;

import lombok.extern.slf4j.Slf4j;
import org.learn.spring.context.ApplicationListener;
import org.learn.spring.context.event.ContextRefreshedEvent;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
@Slf4j
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    log.info("刷新事件: {}", this.getClass().getName());
  }
}
