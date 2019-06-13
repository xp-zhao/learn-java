package com.xp.branch.version2;

/**
 * @description: 消费者类型枚举
 * @author: zhaoxiaoping
 * @create: 2019/06/13
 **/
public enum CustomerEnum {
  /**
   * 内部员工
   */
  Employee(1),
  /**
   * 合作伙伴
   */
  Partner(2);
  /**
   * 类型编码
   */
  private int code;

  CustomerEnum(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }
}