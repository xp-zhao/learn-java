package com.xp.branch.version2;

/**
 * @description: 消费者抽象类
 * @author: zhaoxiaoping
 * @create: 2019/06/13
 **/
public abstract class Customer {

  /**
   * 身份验证
   */
  abstract void validate();

  /**
   * 获取折扣
   */
  abstract double getDiscount();
}