package com.xp.branch.version2;

/**
 * @description: 消费者对象构造器，专门负责创建对象（将对象和对象的创建分开）
 * @author: zhaoxiaoping
 * @create: 2019/06/13
 **/
public class CustomerBuilder {

  public static Customer createCustomer(int type) {
    if (type == CustomerEnum.Employee.getCode()) {
      return new Employee();
    }
    if (type == CustomerEnum.Partner.getCode()) {
      return new Partner();
    }
    return null;
  }
}