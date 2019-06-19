package com.xp.serializable;

import java.io.Serializable;
import lombok.Data;

/**
 * @description: 序列化测试对象实体
 * @author: zhaoxiaoping
 * @create: 2019/06/19
 **/
@Data
public class Student implements Serializable {

  private static final long serialVersionUID = -1986084102700647640L;
  private String name;
  private int age;

  public static String pre = "测试";
  transient String tmp = "hj";

  @Override
  public String toString() {
    return "Student{" + "name=" + name + ",age=" + age + ",pre=" + pre + ",tmp=" + tmp + "}";
  }

}