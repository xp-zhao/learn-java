package com.xp.branch.version1;

/**
 * @description: 消费者对象
 * @author: zhaoxiaoping
 * @create: 2019/06/13
 **/
public class Customer {

  private int type;

  public Customer(int type) {
    this.type = type;
  }

  void validate() {
    if (type == CustomerEnum.Employee.getCode()) {
      System.out.println("内部员工验证");
    } else if (type == CustomerEnum.Partner.getCode()) {
      System.out.println("合作伙伴验证");
    }
  }

  /**
   * 不同的方法中出现了相同的 if 语句，如果新增方法 if 语句还会重复
   * 若要修改条件判断，也需要一个方法一个方法的修改，此时可以使用多态来消除重复的 if 语句 -> version2
   * @return
   */
  double getDiscount() {
    if (type == CustomerEnum.Employee.getCode()) {
      return 0.5;
    } else if (type == CustomerEnum.Partner.getCode()) {
      return 0.7;
    }
    return 1;
  }
}