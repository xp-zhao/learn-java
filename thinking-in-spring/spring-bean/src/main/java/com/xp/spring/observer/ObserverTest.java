package com.xp.spring.observer;

import com.xp.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xp-zhao
 * @description: spring 观察者模式测试
 * @date 2021/4/1
 */
public class ObserverTest {
  public static void main(String[] args) {
    // 创建 ApplicationContext 容器
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext();
    applicationContext.register(AnnotationUserRegisterListener.class);
    applicationContext.register(UserRegisterListener.class);
    applicationContext.refresh();
    User user = new User();
    user.setId(1L);
    user.setName("xp");
    applicationContext.publishEvent(new UserRegisterEvent(applicationContext, user));
  }
}
