package com.xp;

import com.xp.config.UserConfig;
import com.xp.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-9
 **/
public class SpringTest {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
    User user = context.getBean("getUser", User.class);
    System.out.println(user.getName());
  }
}
