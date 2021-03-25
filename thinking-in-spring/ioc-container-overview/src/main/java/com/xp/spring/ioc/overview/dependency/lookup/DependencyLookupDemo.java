package com.xp.spring.ioc.overview.dependency.lookup;

import com.xp.spring.ioc.overview.annotation.Supper;
import com.xp.spring.ioc.overview.domain.User;
import java.util.Map;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhaoxiaoping
 * @Description: 依赖查找示例
 * <p>通过名称的方式来查找</p>
 * @Date 2021-3-25
 **/
public class DependencyLookupDemo {

  public static void main(String[] args) {
    // 配置 xml 配置文件
    // 启动 Spring 上下文
    BeanFactory beanFactory = new ClassPathXmlApplicationContext("dependency-lookup-context.xml");
    // 按照类型查找
    lookupByType(beanFactory);
    // 按照类型查找集合对象
    lookupByCollectionType(beanFactory);
    // 通过注解查询对象
    lookupByAnnotationType(beanFactory);
    // 按照名称查找
//    lookupRealTime(beanFactory);
//    lookupLazy(beanFactory);
  }

  private static void lookupByAnnotationType(BeanFactory beanFactory) {
    if (beanFactory instanceof ListableBeanFactory) {
      ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
      Map<String, User> userMap = (Map) listableBeanFactory.getBeansWithAnnotation(Supper.class);
      System.out.println("查找标注 @Supper 所有的 User 集合对象：" + userMap);
    }
  }

  private static void lookupByCollectionType(BeanFactory beanFactory) {
    if (beanFactory instanceof ListableBeanFactory) {
      ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
      Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
      System.out.println("查找所有的 User 集合对象：" + userMap);
    }
  }

  private static void lookupByType(BeanFactory beanFactory) {
    User user = beanFactory.getBean(User.class);
    System.out.println("实时查找：" + user);
  }

  private static void lookupLazy(BeanFactory beanFactory) {
    ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
    User user = objectFactory.getObject();
    System.out.println("延迟查找：" + user);
  }

  private static void lookupRealTime(BeanFactory beanFactory) {
    User user = (User) beanFactory.getBean("user");
    System.out.println("实时查找：" + user);
  }
}
