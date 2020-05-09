package com.ioc.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020/5/9
 **/
public class TestIoc {

  public static void main(String[] args) {
    ApplicationContext con = new ClassPathXmlApplicationContext("beans.xml");
    User user = con.getBean("user", User.class);
    System.out.println(user);
  }
}
