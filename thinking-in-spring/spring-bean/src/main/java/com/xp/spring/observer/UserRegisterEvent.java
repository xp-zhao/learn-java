package com.xp.spring.observer;

import com.xp.spring.ioc.overview.domain.User;
import org.springframework.context.ApplicationEvent;

/**
 * @author xp-zhao
 * @description: 用户注册事件
 * @date 2021/4/1
 */
public class UserRegisterEvent extends ApplicationEvent {

  /** 注册用户对象 */
  private User user;

  public UserRegisterEvent(Object source, User user) {
    super(source);
    this.user = user;
  }

  public User getUser() {
    return user;
  }
}
