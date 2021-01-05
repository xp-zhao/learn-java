package com.xp.strategy.rule;

/**
 * @author zhaoxiaoping
 * @Description: 基础计算规则
 * @Date 2021-1-5
 **/
public abstract class BaseCalcRule {

  /**
   * 计算方法
   *
   * @param a 操作数
   * @param b 操作数
   * @return 结果
   */
  public abstract int calc(int a, int b);
}
