package com.xp.strategy.rule;

import java.util.Optional;

/**
 * 操作枚举
 *
 * @author lenovo
 */
public enum OprEnum {
  /**
   * 加法
   */
  ADD("ADD", new AddCalcRule()),
  /**
   * 减法
   */
  SUB("SUB", new SubCalcRule());

  public final String name;
  public final BaseCalcRule rule;

  OprEnum(String name, BaseCalcRule rule) {
    this.name = name;
    this.rule = rule;
  }

  public static Optional<OprEnum> match(String name) {
    for (OprEnum value : OprEnum.values()) {
      if (value.name.equals(name)) {
        return Optional.of(value);
      }
    }
    return Optional.empty();
  }
}
