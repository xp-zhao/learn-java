package com.xp.spring.ioc.overview.domain;

/**
 * @author zhaoxiaoping
 * @Description: 用户类
 * @Date 2021-3-25
 **/
public class User {

  private Long id;
  private String name;

  public static User createUser() {
    User user = new User();
    user.setId(1L);
    user.setName("xp");
    return user;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
