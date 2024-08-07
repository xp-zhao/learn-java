package com.spring.example05.v1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhaoxiaoping
 * @date 2024-8-6
 */
@Slf4j
public class DataHandleTest {
  @Test
  public void testBuild() throws IllegalAccessException {
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring.xml");
    UserDataService service = applicationContext.getBean("userDataService", UserDataService.class);
    service.beforeHandle();
    service.commonHandle();
    service.specialHandle();
    service.afterHandle();
  }
}
