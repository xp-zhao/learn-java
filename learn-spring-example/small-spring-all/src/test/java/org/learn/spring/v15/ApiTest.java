package org.learn.spring.v15;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.learn.spring.context.support.ClassPathXmlApplicationContext;
import org.learn.spring.v15.bean.IUserService;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-27
 */
@Slf4j
public class ApiTest {
  @Test
  public void test_autoproxy() throws NoSuchMethodException {
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring-v15.xml");
    IUserService userService = applicationContext.getBean("userService", IUserService.class);
    log.info("测试结果：{}", userService.queryUserInfo());
  }
}
