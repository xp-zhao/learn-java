package com.example.feature.service;

import com.example.feature.event.BaseEvent;
import com.example.feature.event.UserOrderEvent;
import com.example.feature.event.UserRegisterEvent;
import com.example.feature.event.entity.UserOrder;
import com.example.feature.event.entity.UserRegister;
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
    UserRegister userRegister = new UserRegister();
    userRegister.setUserName(userName);
    userRegister.setNickName(userName);
    eventPublisher.publishEvent(new UserRegisterEvent(userRegister, userName));
  }

  public void order(String userName) {
    log.info("[order][用户 {} 下单]", userName);
    // 发布用户下单事件
    UserOrder userOrder = new UserOrder();
    userOrder.setUserName(userName);
    userOrder.setOrderId("1");
    eventPublisher.publishEvent(new UserOrderEvent(userOrder, userName));
  }

  public void eventPublish(String userName) {
    // 发布用户注册事件
    UserRegister userRegister = new UserRegister();
    userRegister.setUserName(userName);
    userRegister.setNickName(userName);
    //    eventPublisher.publishEvent(new UserRegisterEvent(userRegister, userName));
    eventPublisher.publishEvent(new BaseEvent<>(userRegister, userName));
    // 发布用户下单事件
    UserOrder userOrder = new UserOrder();
    userOrder.setUserName(userName);
    userOrder.setOrderId("1");
    //    eventPublisher.publishEvent(new UserOrderEvent(userOrder, userName));
    eventPublisher.publishEvent(new BaseEvent<>(userOrder, userName));
  }

  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.eventPublisher = applicationEventPublisher;
  }
}
