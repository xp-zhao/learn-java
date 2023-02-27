package org.learn.spring.v14;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.learn.spring.context.support.ClassPathXmlApplicationContext;
import org.learn.spring.v14.bean.IUserService;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-27
 */
@Slf4j
public class ApiTest {
  @Test
  public void test_scan() {
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring-v14.xml");
    IUserService userService = applicationContext.getBean("userService", IUserService.class);
    log.info("测试结果：{}", userService.queryUserInfo());
  }
}
