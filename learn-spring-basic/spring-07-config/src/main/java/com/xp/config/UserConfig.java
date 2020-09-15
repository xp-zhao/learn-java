package com.xp.config;

import com.xp.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-9
 **/

// 这个也会被 Spring 容器托管，注册到容器中，它本身也就是一个 @Component 
// @Configuration 代表这是一个配置类，就是以前的 beans.xml
@Configuration
public class UserConfig {

  // 注册一个 bean, 就相当于以前写的一个 bean 标签
  // 这个方法的名字，就相当于 bean 标签中的 id 属性
  // 这个方法的返回值，就相当于 bean 标签中的 class 属性
  @Bean
  public User getUser() {
    return new User();
  }
}
