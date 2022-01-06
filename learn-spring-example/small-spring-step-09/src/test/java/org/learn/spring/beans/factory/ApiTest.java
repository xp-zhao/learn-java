package org.learn.spring.beans.factory;

import org.junit.Test;
import org.learn.spring.beans.factory.bean.UserService;
import org.learn.spring.context.support.ClassPathXmlApplicationContext;
import org.openjdk.jol.info.ClassLayout;

public class ApiTest {
  @Test
  public void test_prototype() {
    // 1.初始化 BeanFactory
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring.xml");
    applicationContext.registerShutdownHook();

    // 2. 获取Bean对象调用方法
    UserService userService01 = applicationContext.getBean("userService", UserService.class);
    UserService userService02 = applicationContext.getBean("userService", UserService.class);

    // 3. 配置 scope="prototype/singleton"
    System.out.println(userService01);
    System.out.println(userService02);

    // 4. 打印十六进制哈希
    System.out.println(userService01 + " 十六进制哈希：" + Integer.toHexString(userService01.hashCode()));
    System.out.println(ClassLayout.parseInstance(userService01).toPrintable());
  }

  @Test
  public void test_factory_bean() {
    // 1.初始化 BeanFactory
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
    applicationContext.registerShutdownHook();

    // 2. 调用代理方法
    UserService userService = applicationContext.getBean("userService", UserService.class);
    System.out.println("测试结果：" + userService.queryUserInfo());
  }
}
