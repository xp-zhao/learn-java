package com.xp.spring.ioc.overview.dependency.injection;

import com.xp.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author zhaoxiaoping
 * @Description: 依赖查找示例
 * <p>通过名称的方式来查找</p>
 * @Date 2021-3-25
 **/
public class DependencyInjectionDemo {

  public static void main(String[] args) {
    // 配置 xml 配置文件
    // 启动 Spring 上下文
    BeanFactory beanFactory = new ClassPathXmlApplicationContext(
        "dependency-injection-context.xml");
    // 依赖来源一：自定义 bean
    UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
    // 依赖来源二：依赖注入 (内建依赖)
    System.out.println(userRepository.getBeanFactory());
    ObjectFactory<ApplicationContext> objectFactory = userRepository.getObjectFactory();
    System.out.println(objectFactory.getObject() == beanFactory);
    // 依赖查找 (错误)
    // System.out.println(beanFactory.getBean(BeanFactory.class));
    // 依赖来源三：容器内建 bean
    Environment environment = beanFactory.getBean(Environment.class);
    System.out.println("获取 Environment 类型的 bean: " + environment);
  }

  private static void whoIsIocContainer(UserRepository userRepository, BeanFactory beanFactory) {
    // ConfigurableApplicationContext <- ApplicationContext <- BeanFactory
    // ApplicationContext is BeanFactory
    // 为什么这个表达式不成立
    System.out.println(userRepository.getBeanFactory() == beanFactory);

  }
}
