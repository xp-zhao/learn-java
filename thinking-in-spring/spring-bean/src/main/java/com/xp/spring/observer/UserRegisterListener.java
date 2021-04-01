package com.xp.spring.observer;

import com.xp.spring.ioc.overview.domain.User;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author xp-zhao
 * @description: 实现接口 {@link ApplicationListener}，监听用户注册
 * @date 2021/4/1
 */
@Component
public class UserRegisterListener implements ApplicationListener<UserRegisterEvent> {
  @Override
  public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
    User user = userRegisterEvent.getUser();
    System.out.println("实现 ApplicationListener 接口：" + user);
  }
}
