package com.xp.pojo;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-8
 **/
public class Hello {

  private String str;

  public String getStr() {
    return str;
  }

  public void setStr(String str) {
    this.str = str;
  }

  @Override
  public String toString() {
    return "Hello{" +
        "str='" + str + '\'' +
        '}';
  }
}
