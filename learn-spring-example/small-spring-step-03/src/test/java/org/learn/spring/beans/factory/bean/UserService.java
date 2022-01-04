package org.learn.spring.beans.factory.bean;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public class UserService {

  private String name;

  public UserService() {}

  public UserService(String name) {
    this.name = name;
  }

  public void queryUserInfo() {
    System.out.println("查询用户信息: " + name);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("");
    sb.append("").append(name);
    return sb.toString();
  }
}
