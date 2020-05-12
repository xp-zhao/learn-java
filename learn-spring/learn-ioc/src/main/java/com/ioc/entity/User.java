package com.ioc.entity;

/**
 * @author zhaoxiaoping
 * @Description: 用户对象
 * @Date 2020/5/9
 **/
public class User {

  private String name;
  private Integer age;

  public User() {
    System.out.println("user 初始化");
  }

  public User(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
