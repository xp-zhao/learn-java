package com.xp.strategy.rule;

/**
 * 操作枚举
 *
 * @author lenovo
 */
public enum OprEnum {
  /**
   * 加法
   */
  ADD("ADD"),
  /**
   * 减法
   */
  SUB("SUB");

  public String name;
  public BaseCalcRule rule;

  OprEnum(String name) {
    this.name = name;
  }
}
