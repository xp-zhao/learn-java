package com.example.feature.mock.bean;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-3-6
 */
public class MockUser {
  private String id;
  private String name;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MockUser() {}

  public MockUser(String id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public String toString() {
    return "User{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
  }
}
