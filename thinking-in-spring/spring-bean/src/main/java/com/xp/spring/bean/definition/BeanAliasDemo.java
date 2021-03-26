package com.xp.spring.bean.definition;

import com.xp.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhaoxiaoping
 * @Description: Bean 别名示例
 * @Date 2021-3-26
 **/
public class BeanAliasDemo {

  public static void main(String[] args) {
    // 配置 xml 配置文件
    BeanFactory beanFactory = new ClassPathXmlApplicationContext("bean-definitions-context.xml");
    // 通过 bean 名称与别名获取 bean
    User user = beanFactory.getBean("user", User.class);
    User xpUser = beanFactory.getBean("xp-user", User.class);
    System.out.println("xp-user 是否与 user bean 相同：" + (user == xpUser));
  }
}
