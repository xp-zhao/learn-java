package org.learn.spring.test;

import org.junit.Test;
import org.learn.spring.context.support.ClassPathXmlApplicationContext;
import org.learn.spring.test.beans.Husband;
import org.learn.spring.test.beans.Wife;

/**
 * @author zhaoxiaoping
 * @date 2022-3-7
 */
public class ApiTest {
  @Test
  public void test_circular() {
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
    Husband husband = applicationContext.getBean("husband", Husband.class);
    Wife wife = applicationContext.getBean("wife", Wife.class);
    System.out.println("老公的媳妇：" + husband.queryWife());
    System.out.println("媳妇的老公：" + wife.queryHusband());
  }
}
