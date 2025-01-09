package com.example.feature.event;

import com.example.feature.event.entity.UserRegister;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author xp-zhao
 * @description 用户注册事件
 * @date 2022/9/23 21:57
 */
public class UserRegisterEvent extends ApplicationEvent {

  @Getter private String userName;

  public UserRegisterEvent(UserRegister source) {
    super(source);
  }

  public UserRegisterEvent(UserRegister source, String userName) {
    super(source);
    this.userName = userName;
  }
}
