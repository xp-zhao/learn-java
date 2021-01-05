package com.xp.strategy.rule;

/**
 * @author zhaoxiaoping
 * @Description: 客户端
 * @Date 2021-1-5
 **/
public class Client {

  public static void main(String[] args) {
    String opr = "SUB";
    int a = 2, b = 3;
    OprEnum match = OprEnum.match(opr).orElse(OprEnum.ADD);
    BaseCalcRule rule = match.rule;
    System.out.println(rule.calc(a, b));
  }
}
