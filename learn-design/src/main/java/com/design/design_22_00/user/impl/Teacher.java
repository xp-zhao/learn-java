package com.design.design_22_00.user.impl;

import com.design.design_22_00.user.User;
import com.design.design_22_00.visitor.Visitor;
import java.math.BigDecimal;

/**
 * 教师
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
public class Teacher extends User {

  public Teacher(String name, String identity, String clazz) {
    super(name, identity, clazz);
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  /**
   * 升本率
   *
   * @return double
   */
  public double entranceRatio() {
    return BigDecimal.valueOf(Math.random() * 100)
        .setScale(2, BigDecimal.ROUND_HALF_UP)
        .doubleValue();
  }
}
