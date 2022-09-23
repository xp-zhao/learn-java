package com.example.feature.service;

import com.example.feature.event.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author xp-zhao
 * @description 用户服务类
 * @date 2022/9/23 21:59
 */
@Slf4j
@Service
public class UserService implements ApplicationEventPublisherAware {

  private ApplicationEventPublisher eventPublisher;

  public void register(String userName) {
    log.info("[register][用户 {} 注册]", userName);
    // 发布用户注册事件
    eventPublisher.publishEvent(new UserRegisterEvent(this, userName));
  }

  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.eventPublisher = applicationEventPublisher;
  }
}
