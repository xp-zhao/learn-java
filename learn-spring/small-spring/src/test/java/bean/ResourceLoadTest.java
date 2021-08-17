package bean;

import cn.hutool.core.io.IoUtil;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Before;
import org.junit.Test;
import org.smallspring.beans.factory.supprot.DefaultListableBeanFactory;
import org.smallspring.beans.factory.xml.XmlBeanDefinitionReader;
import org.smallspring.core.io.DefaultResourceLoader;
import org.smallspring.core.io.Resource;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-8-17
 **/
public class ResourceLoadTest {
  private DefaultResourceLoader resourceLoader;

  @Before
  public void init() {
    resourceLoader = new DefaultResourceLoader();
  }
  
  @Test
  public void testClasspath() throws IOException {
    Resource resource = resourceLoader.getResource("classpath:important.properties");
    InputStream inputStream = resource.getInputStream();
    String content = IoUtil.readUtf8(inputStream);
    System.out.println(content);
  }

  @Test
  public void testFile() throws IOException {
    Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
    InputStream inputStream = resource.getInputStream();
    String content = IoUtil.readUtf8(inputStream);
    System.out.println(content);
  }

  @Test
  public void testUrl() throws IOException {
    Resource resource = resourceLoader.getResource("https://xxx.com/important.properties");
    InputStream inputStream = resource.getInputStream();
    String content = IoUtil.readUtf8(inputStream);
    System.out.println(content);
  }
  
  @Test
  public void testXml(){
    // 1.初始化 BeanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    // 2. 读取配置文件&注册Bean
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
    reader.loadBeanDefinitions("classpath:spring.xml");

    // 3. 获取Bean对象调用方法
    UserService userService = beanFactory.getBean("userService", UserService.class);
    userService.queryUserInfo();
  }
}
