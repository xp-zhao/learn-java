package com.xp.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-9
 **/

// 这个注解的意思，就是说明这个类被 Spring 接管了
// 注册到了容器中
@Component
public class User {

  @Value("xxx")
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        '}';
  }
}
