package org.learn.spring.test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.config.BeanPostProcessor;
import org.learn.spring.context.support.ClassPathXmlApplicationContext;
import org.learn.spring.test.beans.IUserService;

/**
 * @author zhaoxiaoping
 * @date 2022-3-7
 */
public class ApiTest {
  @Test
  public void test_scan() {
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
    IUserService userService = applicationContext.getBean("userService", IUserService.class);
    System.out.println("测试结果：" + userService.queryUserInfo());
  }

  @Test
  public void test_property() {
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring-property.xml");
    IUserService userService = applicationContext.getBean("userService", IUserService.class);
    System.out.println("测试结果：" + userService);
  }

  @Test
  public void test_beanPost() {

    BeanPostProcessor beanPostProcessor =
        new BeanPostProcessor() {
          @Override
          public Object postProcessBeforeInitialization(Object bean, String beanName)
              throws BeansException {
            return null;
          }

          @Override
          public Object postProcessAfterInitialization(Object bean, String beanName)
              throws BeansException {
            return null;
          }
        };

    List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();
    beanPostProcessors.add(beanPostProcessor);
    beanPostProcessors.add(beanPostProcessor);
    beanPostProcessors.remove(beanPostProcessor);

    System.out.println(beanPostProcessors.size());
  }
}
