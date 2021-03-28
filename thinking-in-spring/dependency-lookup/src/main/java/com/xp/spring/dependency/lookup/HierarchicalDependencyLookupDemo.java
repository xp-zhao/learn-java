package com.xp.spring.dependency.lookup;

import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xp-zhao
 * @description: 层次性依赖查找示例
 * @date 2021/3/28
 */
public class HierarchicalDependencyLookupDemo {
  public static void main(String[] args) {
    // 创建 ApplicationContext 容器
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext();
    // 将当前类 ObjectProviderDemo 作为配置类 (Configuration Class)
    applicationContext.register(ObjectProviderDemo.class);

    // 1. 获取 HierarchicalBeanFactory <- ConfigurableBeanFactory <- ConfigurableListableBeanFactory
    ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
    System.out.println(
        "当前 BeanFactory 的 Parent BeanFactory: " + beanFactory.getParentBeanFactory());
    // 2. 设置 Parent BeanFactory
    ConfigurableListableBeanFactory parentBeanFactory = createParentBeanFactory();
    beanFactory.setParentBeanFactory(parentBeanFactory);
    System.out.println(
        "当前 BeanFactory 的 Parent BeanFactory: " + beanFactory.getParentBeanFactory());
    displayLocalBean(beanFactory, "user");
    displayLocalBean(parentBeanFactory, "user");
    // 启动应用上下文
    applicationContext.refresh();
    // 关闭应用上下文
    applicationContext.close();
  }

  private static void displayLocalBean(HierarchicalBeanFactory beanFactory, String beanName) {
    System.out.printf(
        "当前 BeanFactory[%s] 是否保护 bean[name : %s] : %s",
        beanFactory, beanName, beanFactory.containsLocalBean(beanName));
  }

  private static ConfigurableListableBeanFactory createParentBeanFactory() {
    // 创建 BeanFactory 容器
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
    // xml 配置文件路径
    String location = "dependency-lookup-context.xml";
    // 加载配置
    reader.loadBeanDefinitions(location);
    return beanFactory;
  }
}
