package com.xp.spring.bean.definition;

import com.xp.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author zhaoxiaoping
 * @Description: 注解 BeanDefinition 示例
 * @Date 2021-3-26
 **/

/**
 * 通过 @Import 来进行导入
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

  public static void main(String[] args) {
    // 创建 ApplicationContext 容器
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    // 注册 Configuration Class(配置类)
    applicationContext.register(Config.class);

    // 通过 BeanDefinition 注册 API 实现
    // 1. 命名 bean 的注册方式
    registerUserBeanDefinition(applicationContext, "beanName-user");
    // 2. 非命名方式
    registerUserBeanDefinition(applicationContext);

    // 启动 Spring 应用上下文
    applicationContext.refresh();
    // 按照类型依赖查找
    System.out.println("Config 类型的所有 Beans: " + applicationContext.getBeansOfType(Config.class));
    System.out.println("User 类型的所有 Beans: " + applicationContext.getBeansOfType(User.class));
    // 显式的关闭 Spring 应用上下文
    applicationContext.close();
  }

  /**
   * 命名 bean 的注册方式
   *
   * @param registry
   * @param beanName
   */
  public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
    BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
        .genericBeanDefinition(User.class);
    beanDefinitionBuilder.addPropertyValue("id", 1L).addPropertyValue("name", "xp-user");
    // 判断 beanName 是否存在
    if (StringUtils.hasText(beanName)) {
      // 注册 BeanDefinition
      registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
    } else {
      // 非命名的注册方式
      BeanDefinitionReaderUtils
          .registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
    }

  }

  public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
    registerUserBeanDefinition(registry, null);
  }

  /**
   * 定义当前类作为 Spring Bean(组件)
   */
  @Component
  public static class Config {

    /**
     * 通过 Java 注解的方式定义了一个 Bean
     */
    @Bean(name = {"user", "xp-user"})
    public User user() {
      User user = new User();
      user.setId(1L);
      user.setName("xp");
      return user;
    }
  }
}
