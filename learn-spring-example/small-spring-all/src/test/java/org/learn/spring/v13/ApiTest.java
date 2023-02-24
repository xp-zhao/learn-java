package org.learn.spring.v13;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.learn.spring.context.support.ClassPathXmlApplicationContext;
import org.learn.spring.v13.bean.IUserService;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-24
 */
@Slf4j
public class ApiTest {
  @Test
  public void test_scan() {
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
    IUserService userService = applicationContext.getBean("userService", IUserService.class);
    log.info("测试结果：{}", userService.queryUserInfo());
  }

  @Test
  public void test_property() {
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring-property.xml");
    IUserService userService = applicationContext.getBean("userService", IUserService.class);
    log.info("测试结果：{}, ", userService);
  }
}
