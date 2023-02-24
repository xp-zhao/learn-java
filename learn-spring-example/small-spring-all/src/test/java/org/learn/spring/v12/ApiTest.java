package org.learn.spring.v12;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.learn.spring.context.support.ClassPathXmlApplicationContext;
import org.learn.spring.v12.bean.IUserService;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-23
 */
@Slf4j
public class ApiTest {
  @Test
  public void test_aop() {
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring-v12.xml");
    applicationContext.registerShutdownHook();
    IUserService userService = applicationContext.getBean("userService", IUserService.class);
    log.info("测试结果: {}", userService.queryUserInfo());
  }
}
