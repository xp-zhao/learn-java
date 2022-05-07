package org.learn.spring.test;

import org.junit.Test;
import org.learn.spring.context.support.ClassPathXmlApplicationContext;
import org.learn.spring.test.beans.IUserService;

/**
 * @author zhaoxiaoping
 * @date 2022-3-7
 */
public class ApiTest {
  @Test
  public void test_scan() {
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring.xml");
    IUserService userService = applicationContext.getBean("userService", IUserService.class);
    System.out.println("测试结果：" + userService.queryUserInfo());
  }
}
