package org.learn.spring.v10.bean;

import lombok.extern.slf4j.Slf4j;
import org.learn.spring.context.ApplicationListener;

import java.time.LocalDate;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
@Slf4j
public class CustomEventListener implements ApplicationListener<CustomEvent> {
  @Override
  public void onApplicationEvent(CustomEvent event) {
    log.info("收到: {} 消息; 时间: {}", event.getSource(), LocalDate.now());
    log.info("消息: {} : {}", event.getId(), event.getMessage());
  }
}
