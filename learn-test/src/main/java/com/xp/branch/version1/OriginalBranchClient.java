package com.xp.branch.version1;

/**
 * @description: 测试客户端
 * @author: zhaoxiaoping
 * @create: 2019/06/13
 **/
public class OriginalBranchClient {

  public static void main(String[] args) {
    Customer employee = new Customer(1);
    Customer partner = new Customer(2);

    employee.validate();
    partner.validate();
    System.out.println("内部员工折扣：" + employee.getDiscount());
    System.out.println("合作伙伴折扣：" + partner.getDiscount());
  }
}