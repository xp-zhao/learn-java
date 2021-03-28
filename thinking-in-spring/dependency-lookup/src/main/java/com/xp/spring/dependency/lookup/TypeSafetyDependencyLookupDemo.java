package com.xp.spring.dependency.lookup;

import com.xp.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xp-zhao
 * @description: 类型安全 依赖查找示例
 * @date 2021/3/28
 */
public class TypeSafetyDependencyLookupDemo {
  public static void main(String[] args) {
    // 创建 ApplicationContext 容器
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext();
    // 将当前类 TypeSafetyDependencyLookupDemo 作为配置类 (Configuration Class)
    applicationContext.register(TypeSafetyDependencyLookupDemo.class);
    // 启动应用上下文
    applicationContext.refresh();
    // 演示 BeanFactory#getBean 方法的安全性
    displayBeanFactoryGetBean(applicationContext);
    // 演示 ObjectFactory#getObject 方法的安全性
    displayObjectFactoryGetObject(applicationContext);
    // 演示 ObjectProvider#getIfAvailable 方法的安全性
    displayObjectProviderIfAvailable(applicationContext);
    // 演示 ListableBeanFactory#getBeansOfType 方法的安全性
    displayListableBeanFactory(applicationContext);
    // 关闭应用上下文
    applicationContext.close();
  }

  private static void displayListableBeanFactory(ListableBeanFactory beanFactory) {
    printBeanException("displayListableBeanFactory", () -> beanFactory.getBeansOfType(User.class));
  }

  private static void displayObjectProviderIfAvailable(
      AnnotationConfigApplicationContext applicationContext) {
    ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
    printBeanException(
        "displayObjectProviderIfAvailable", () -> userObjectProvider.getIfAvailable());
  }

  private static void displayObjectFactoryGetObject(
      AnnotationConfigApplicationContext applicationContext) {
    ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
    printBeanException("displayObjectFactoryGetObject", () -> userObjectProvider.getObject());
  }

  private static void displayBeanFactoryGetBean(BeanFactory beanFactory) {
    printBeanException("displayBeanFactoryGetBean", () -> beanFactory.getBean(User.class));
  }

  private static void printBeanException(String source, Runnable runnable) {
    System.out.println("===========================");
    System.out.println("Source from : " + source);
    try {
      runnable.run();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
