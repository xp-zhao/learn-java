package org.learn.spring.beans.factory;

import org.junit.Test;
import org.learn.spring.beans.factory.event.CustomEvent;
import org.learn.spring.context.support.ClassPathXmlApplicationContext;

public class ApiTest {
  @Test
  public void test_event() {
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring.xml");
    applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

    applicationContext.registerShutdownHook();
  }
}
