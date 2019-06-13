package com.xp.branch.version2;

/**
 * @description: 内部员工
 * @author: zhaoxiaoping
 * @create: 2019/06/13
 **/
public class Employee extends Customer {

  @Override
  void validate() {
    System.out.println("内部员工验证");
  }

  @Override
  double getDiscount() {
    return 0.5;
  }
}