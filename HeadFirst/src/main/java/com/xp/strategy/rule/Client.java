package com.xp.strategy.rule;

/**
 * @author zhaoxiaoping
 * @Description: 客户端
 * @Date 2021-1-5
 **/
public class Client {

  public static void main(String[] args) {
    String opr = "ADD";
    int a = 2, b = 3;
    BaseCalcRule rule;
    if (OprEnum.ADD.name.equals(opr)) {
      rule = new AddCalcRule();
    } else {
      rule = new SubCalcRule();
    }
    System.out.println(rule.calc(a, b));
  }
}
