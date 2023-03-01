package org.learn.spring.v16;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.learn.spring.context.support.ClassPathXmlApplicationContext;
import org.learn.spring.v16.bean.Husband;
import org.learn.spring.v16.bean.Wife;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-27
 */
@Slf4j
public class ApiTest {
  @Test
  public void test_circular() {
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring-v16.xml");
    Husband husband = applicationContext.getBean("husband", Husband.class);
    Wife wife = applicationContext.getBean("wife", Wife.class);
    log.info("老公的媳妇: {}", husband.queryWife());
    log.info("媳妇的老公: {}", wife.queryHusband());
  }
}
