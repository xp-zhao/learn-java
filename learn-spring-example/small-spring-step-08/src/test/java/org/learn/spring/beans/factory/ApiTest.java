package org.learn.spring.beans.factory;

import org.junit.Test;
import org.learn.spring.beans.factory.bean.UserService;
import org.learn.spring.context.support.ClassPathXmlApplicationContext;

public class ApiTest {
  @Test
  public void test_xml() {
    // 1.初始化 BeanFactory
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring.xml");
    applicationContext.registerShutdownHook();

    // 2. 获取Bean对象调用方法
    UserService userService = applicationContext.getBean("userService", UserService.class);
    String result = userService.queryUserInfo();
    System.out.println("测试结果：" + result);

    System.out.println("ApplicationContextAware：" + userService.getApplicationContext());
    System.out.println("BeanFactoryAware：" + userService.getBeanFactory());
  }
}
