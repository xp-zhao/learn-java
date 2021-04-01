package com.xp.spring.observer;

import com.xp.spring.ioc.overview.domain.User;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author xp-zhao
 * @description: 注解 {@link EventListener}实现用户注册监听
 * @date 2021/4/1
 */
@Component
public class AnnotationUserRegisterListener {
  /**
   * 注册监听 实现方法
   *
   * @param userRegisterEvent 注册事件
   */
  @EventListener
  public void register(UserRegisterEvent userRegisterEvent) {
    User user = userRegisterEvent.getUser();
    System.out.println("使用注解 EventListener：" + user);
  }
}
