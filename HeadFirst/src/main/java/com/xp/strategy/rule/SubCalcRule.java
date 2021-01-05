package com.xp.strategy.rule;

/**
 * @author zhaoxiaoping
 * @Description: 减法计算规则
 * @Date 2021-1-5
 **/
public class SubCalcRule extends BaseCalcRule {

  @Override
  public int calc(int a, int b) {
    return a - b;
  }
}
