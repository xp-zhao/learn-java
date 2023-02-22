package org.learn.spring.v9;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.learn.spring.context.support.ClassPathXmlApplicationContext;
import org.learn.spring.v9.bean.UserService;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
@Slf4j
public class ApiTest {
  @Test
  public void test_scope() {
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring-v9.xml");
    applicationContext.registerShutdownHook();
    UserService userService01 = applicationContext.getBean("userService", UserService.class);
    UserService userService02 = applicationContext.getBean("userService", UserService.class);
    log.info("userService01: {}", userService01);
    log.info("userService02: {}", userService02);
  }

  @Test
  public void test_factory_bean() {
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring-v9.xml");
    applicationContext.registerShutdownHook();
    UserService userService = applicationContext.getBean("userService", UserService.class);
    userService.setUId("10002");
    log.info("测试结果: {}", userService.queryUserInfo());
  }
}
