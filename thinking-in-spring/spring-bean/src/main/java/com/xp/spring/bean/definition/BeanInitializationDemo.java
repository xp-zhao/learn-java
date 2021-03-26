package com.xp.spring.bean.definition;

import com.xp.spring.bean.factory.DefaultUserFactory;
import com.xp.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author zhaoxiaoping
 * @Description: Bean 初始化 Demo
 * @Date 2021-3-26
 **/
@Configuration
public class BeanInitializationDemo {

  public static void main(String[] args) {
    // 创建 ApplicationContext 容器
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    // 注册 Configuration Class(配置类)
    applicationContext.register(BeanInitializationDemo.class);
    // 启动应用上下文
    applicationContext.refresh();
    // 非延迟初始化在 Spring 应用上下文启动完成后，被初始化
    System.out.println("Spring 应用上下文已启动...");
    // 依赖查找 UserFactory
    UserFactory userFactory = applicationContext.getBean(UserFactory.class);
    System.out.println(userFactory);
    System.out.println("Spring 应用上下文准备关闭...");
    // 关闭应用上下文
    applicationContext.close();
    System.out.println("Spring 应用上下文已关闭...");
  }

  @Bean(initMethod = "initUserFactory", destroyMethod = "doDestroy")
  @Lazy(value = false)
  public UserFactory userFactory() {
    return new DefaultUserFactory();
  }
}
