package com.xp;

import com.xp.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-8
 **/
public class IOCTest {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    UserService userService = (UserService) context.getBean("userServiceImpl");
    userService.getUser();
  }
}
