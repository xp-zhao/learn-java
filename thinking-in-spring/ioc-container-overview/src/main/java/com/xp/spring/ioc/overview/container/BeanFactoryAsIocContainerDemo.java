package com.xp.spring.ioc.overview.container;

import com.xp.spring.ioc.overview.domain.User;
import java.util.Map;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author zhaoxiaoping
 * @Description: {@link BeanFactory} 作为 Ioc 容器示例
 * @Date 2021-3-26
 **/
public class BeanFactoryAsIocContainerDemo {

  public static void main(String[] args) {
    // 创建 BeanFactory 容器
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
    // xml 配置文件路径
    String location = "dependency-lookup-context.xml";
    // 加载配置
    int beanDefinitionsCount = reader.loadBeanDefinitions(location);
    System.out.println(beanDefinitionsCount);
    // 依赖查找集合对象
    lookupByCollectionType(beanFactory);
  }

  private static void lookupByCollectionType(BeanFactory beanFactory) {
    if (beanFactory instanceof ListableBeanFactory) {
      ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
      Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
      System.out.println("查找所有的 User 集合对象：" + userMap);
    }
  }
}
