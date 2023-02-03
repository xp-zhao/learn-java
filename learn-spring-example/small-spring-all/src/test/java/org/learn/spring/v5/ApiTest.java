package org.learn.spring.v5;

import cn.hutool.core.io.IoUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.learn.spring.beans.factory.support.DefaultListableBeanFactory;
import org.learn.spring.beans.factory.xml.XmlBeanDefinitionReader;
import org.learn.spring.core.io.DefaultResourceLoader;
import org.learn.spring.core.io.Resource;
import org.learn.spring.v5.bean.UserService;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class ApiTest {
  private DefaultResourceLoader resourceLoader;

  @Before
  public void init() {
    resourceLoader = new DefaultResourceLoader();
  }

  @Test
  public void test_classpath() throws IOException {
    Resource resource = resourceLoader.getResource("classpath:important.properties");
    InputStream inputStream = resource.getInputStream();
    String content = IoUtil.readUtf8(inputStream);
    log.info(content);
  }

  @Test
  public void test_xml() {
    // 1.初始化 BeanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

    // 2. 读取配置文件&注册Bean
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
    reader.loadBeanDefinitions("classpath:spring-v5.xml");

    // 3. 获取Bean对象调用方法
    UserService userService = beanFactory.getBean("userService", UserService.class);
    String result = userService.queryUserInfo();
    log.info("测试结果：" + result);
  }
}
