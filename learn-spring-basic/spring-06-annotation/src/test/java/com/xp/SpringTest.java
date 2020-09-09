package com.xp;

import com.xp.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-9
 **/
public class SpringTest {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    User user = context.getBean("user", User.class);
    System.out.println(user.name);
  }
}
