package com.example.feature.event;

import com.example.feature.event.entity.UserOrder;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author xp-zhao
 * @description 用户下单事件
 * @date 2025/1/8 17:08
 */
public class UserOrderEvent extends ApplicationEvent {
  @Getter private String userName;

  public UserOrderEvent(UserOrder source) {
    super(source);
  }

  public UserOrderEvent(UserOrder source, String userName) {
    super(source);
    this.userName = userName;
  }
}
