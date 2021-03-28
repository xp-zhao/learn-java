package com.xp.spring.dependency.lookup;

import com.xp.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * @author xp-zhao
 * @description: 通过 {@link ObjectProvider} 进行依赖查找
 * @date 2021/3/28
 */
// @Configuration 是非必须的注解
public class ObjectProviderDemo {
  public static void main(String[] args) {
    // 创建 ApplicationContext 容器
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext();
    // 将当前类 ObjectProviderDemo 作为配置类 (Configuration Class)
    applicationContext.register(ObjectProviderDemo.class);
    // 启动应用上下文
    applicationContext.refresh();
    // 依赖查找集合对象
    lookupByObjectProvider(applicationContext);
    lookupIfAvailable(applicationContext);
    lookupIfAvailable(applicationContext);
    lookupByStreamOps(applicationContext);
    // 关闭应用上下文
    applicationContext.close();
  }

  private static void lookupByStreamOps(AnnotationConfigApplicationContext applicationContext) {
    ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
    objectProvider.stream().forEach(System.out::println);
  }

  private static void lookupIfAvailable(AnnotationConfigApplicationContext applicationContext) {
    ObjectProvider<User> beanProvider = applicationContext.getBeanProvider(User.class);
    User user = beanProvider.getIfAvailable(User::createUser);
    System.out.println("当前 User 对象： " + user);
  }

  @Bean
  @Primary
  public String helloWorld() {
    return "Hello, World";
  }

  @Bean
  public String message() {
    return "message";
  }

  private static void lookupByObjectProvider(
      AnnotationConfigApplicationContext applicationContext) {
    ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
    System.out.println(objectProvider.getObject());
  }
}
