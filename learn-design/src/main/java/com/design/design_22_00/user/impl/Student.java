package com.design.design_22_00.user.impl;

import com.design.design_22_00.user.User;
import com.design.design_22_00.visitor.Visitor;

/**
 * 学生
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
public class Student extends User {

  public Student(String name, String identity, String clazz) {
    super(name, identity, clazz);
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public int ranking() {
    return (int) (Math.random() * 100);
  }
}
