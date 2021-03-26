package com.xp.spring.ioc.overview.container;

import com.xp.spring.ioc.overview.domain.User;
import java.util.Map;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaoxiaoping
 * @Description: 注解能力 {@link ApplicationContext} 作为 Ioc 容器示例
 * @Date 2021-3-26
 **/
@Configuration
public class AnnotationApplicationContextAsIocContainerDemo {

  public static void main(String[] args) {
    // 创建 ApplicationContext 容器
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    // 将当前类 AnnotationApplicationContextAsIocContainerDemo 作为配置类 (Configuration Class)
    applicationContext.register(AnnotationApplicationContextAsIocContainerDemo.class);
    // 启动应用上下文
    applicationContext.refresh();
    // 依赖查找集合对象
    lookupByCollectionType(applicationContext);
  }

  @Bean
  public User user() {
    User user = new User();
    user.setId(1L);
    user.setName("xp");
    return user;
  }

  private static void lookupByCollectionType(BeanFactory beanFactory) {
    if (beanFactory instanceof ListableBeanFactory) {
      ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
      Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
      System.out.println("查找所有的 User 集合对象：" + userMap);
    }
  }
}
