package com.xp.spring.bean.definition;

import com.xp.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhaoxiaoping
 * @Description: Bean 实例化示例
 * @Date 2021-3-26
 **/
public class BeanInstantiationDemo {

  public static void main(String[] args) {
    // 配置 xml 配置文件
    // 启动 Spring 上下文
    BeanFactory beanFactory = new ClassPathXmlApplicationContext(
        "bean-instantiation-context.xml");
    User user = beanFactory.getBean("user-by-static-method", User.class);
    User userByInstanceMethod = beanFactory.getBean("user-by-instance-method", User.class);
    User userByFactoryBean = beanFactory.getBean("user-by-factory-bean", User.class);
    System.out.println(user);
    System.out.println(userByInstanceMethod);
    System.out.println(userByFactoryBean);
    System.out.println(user == userByInstanceMethod);
    System.out.println(user == userByFactoryBean);
  }
}
