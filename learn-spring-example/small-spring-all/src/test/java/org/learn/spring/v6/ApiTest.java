package org.learn.spring.v6;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.learn.spring.beans.factory.support.DefaultListableBeanFactory;
import org.learn.spring.beans.factory.xml.XmlBeanDefinitionReader;
import org.learn.spring.context.support.ClassPathXmlApplicationContext;
import org.learn.spring.v6.bean.UserService;
import org.learn.spring.v6.common.MyBeanFactoryPostProcessor;
import org.learn.spring.v6.common.MyBeanPostProcessor;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-3
 */
@Slf4j
public class ApiTest {
  @Test
  public void test_BeanFactoryPostProcessorAndBeanPostProcessor() {
    // 初始化 BeanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

    // 读取配置文件 & 注册BeanDefinition
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
    reader.loadBeanDefinitions("classpath:spring-v6.xml");

    // BeanDefinition 加载完成之后, 提供修改 BeanDefinition 的拓展
    MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
    beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

    // 注册 BeanPostProcessor , 提供 bean 实例化之后修改 bean 信息的拓展
    MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
    beanFactory.addBeanPostProcessor(beanPostProcessor);

    // 获取 bean
    UserService userService = beanFactory.getBean("userService", UserService.class);
    log.info("测试结果: {}", userService.queryUserInfo());
  }

  @Test
  public void test_xml() {
    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
    UserService userService = context.getBean("userService", UserService.class);
    log.info("测试结果: {}", userService.queryUserInfo());
  }
}
