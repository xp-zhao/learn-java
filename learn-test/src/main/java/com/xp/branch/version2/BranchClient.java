package com.xp.branch.version2;

/**
 * @description: 多态消除分支测试
 * @author: zhaoxiaoping
 * @create: 2019/06/13
 **/
public class BranchClient {

  public static void main(String[] args) {
    Employee employee = (Employee) CustomerBuilder.createCustomer(1);
    Partner partner = (Partner) CustomerBuilder.createCustomer(2);

    employee.validate();
    System.out.println("内部员工折扣：" + employee.getDiscount());

    partner.validate();
    System.out.println("合作伙伴折扣：" + partner.getDiscount());
  }
}