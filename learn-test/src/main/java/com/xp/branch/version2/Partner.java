package com.xp.branch.version2;

/**
 * @description: 合作伙伴
 * @author: zhaoxiaoping
 * @create: 2019/06/13
 **/
public class Partner extends Customer {

  @Override
  void validate() {
    System.out.println("合作伙伴验证");
  }

  @Override
  double getDiscount() {
    return 0.7;
  }
}