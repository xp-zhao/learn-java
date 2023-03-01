package org.learn.spring.v16.bean;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-28
 */
public class Husband {
  private Wife wife;

  public String queryWife() {
    return "Husband.wife";
  }

  public Wife getWife() {
    return wife;
  }

  public void setWife(Wife wife) {
    this.wife = wife;
  }
}
