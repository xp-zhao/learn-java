package com.spring.example05.v2;

import com.spring.example05.v2.context.UserDataContext;
import com.spring.example05.v2.factory.DataHandleProcessFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2024-8-7
 */
@Slf4j
public class DataHandleTest {
  @Test
  public void testBuild() throws IllegalAccessException {
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring.xml");
    DataHandleProcessFactory factory =
        applicationContext.getBean("dataHandleProcessFactory", DataHandleProcessFactory.class);
    UserDataContext context = new UserDataContext();
    context.setUserId("111");
    UserDataContext result = factory.execute(context, "dataHandleProcess");
    log.info(result.getUserId());
  }
}
