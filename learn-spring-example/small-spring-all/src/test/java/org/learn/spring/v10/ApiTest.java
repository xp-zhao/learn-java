package org.learn.spring.v10;

import org.junit.Test;
import org.learn.spring.context.support.ClassPathXmlApplicationContext;
import org.learn.spring.v10.bean.CustomEvent;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
public class ApiTest {
  @Test
  public void test_event() {
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring-v10.xml");
    applicationContext.publishEvent(new CustomEvent(applicationContext, 123456L, "自定义事件"));
    applicationContext.registerShutdownHook();
  }
}
