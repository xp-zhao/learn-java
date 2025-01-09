package com.example.feature.service;

import com.example.feature.event.BaseEvent;
import com.example.feature.event.UserOrderEvent;
import com.example.feature.event.UserRegisterEvent;
import com.example.feature.event.entity.UserOrder;
import com.example.feature.event.entity.UserRegister;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventListenerService {
  @EventListener
  public void userRegister(UserRegisterEvent event) {
    log.info("监听到 UserRegisterEvent: {}", event);
  }

  @EventListener
  public void userOrder(UserOrderEvent event) {
    log.info("监听到 UserOrderEvent: {}", event);
  }

  //  @EventListener
  //  public void eventHandle(BaseEvent<?> event) {
  //    Object source = event.getSource();
  //    if (source instanceof UserRegister) {
  //      log.info("监听到: register, {}", event);
  //    } else if (source instanceof UserOrder) {
  //      log.info("监听到 order, {}", event);
  //    }
  //  }

  @EventListener
  public void registerEventHandle(BaseEvent<UserRegister> event) {
    log.info("监听到: register, {}", event);
  }

  @EventListener
  public void orderEventHandle(BaseEvent<UserOrder> event) {
    log.info("监听到: order, {}", event);
  }
}
