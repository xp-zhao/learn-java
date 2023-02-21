package org.learn.spring.v8;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.learn.spring.context.support.ClassPathXmlApplicationContext;
import org.learn.spring.v8.bean.UserService;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-21
 */
@Slf4j
public class ApiTest {
  @Test
  public void test_xml() {
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring-v8.xml");
    applicationContext.registerShutdownHook();
    UserService userService = applicationContext.getBean("userService", UserService.class);
    String result = userService.queryUserInfo();
    log.info("测试结果: {}", result);
    log.info("ApplicationContext: {}", userService.getApplicationContext());
    log.info("BeanFactory: {}", userService.getBeanFactory());
  }
}
