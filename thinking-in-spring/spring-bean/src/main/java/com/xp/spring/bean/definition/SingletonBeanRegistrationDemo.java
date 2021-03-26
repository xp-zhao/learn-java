package com.xp.spring.bean.definition;

import com.xp.spring.bean.factory.DefaultUserFactory;
import com.xp.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhaoxiaoping
 * @Description: 单体 Bean 注册实例
 * @Date 2021-3-26
 **/
public class SingletonBeanRegistrationDemo {

  public static void main(String[] args) {
    // 创建 ApplicationContext 容器
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    // 创建一个外部 UserFactory 对象
    UserFactory userFactory = new DefaultUserFactory();
    ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
    // 注册外部单例对象
    beanFactory.registerSingleton("userFactory", userFactory);

    // 启动 Spring 应用上下文
    applicationContext.refresh();
    // 通过依赖查找的方式获取 UserFactory
    UserFactory userFactoryLookup = beanFactory.getBean("userFactory", UserFactory.class);
    System.out.println("userFactory == userFactoryLookup : " + (userFactory == userFactoryLookup));
    // 显式的关闭 Spring 应用上下文
    applicationContext.close();
  }
}
