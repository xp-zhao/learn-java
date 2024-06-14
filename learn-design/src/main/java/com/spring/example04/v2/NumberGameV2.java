package com.spring.example04.v2;

/**
 * @author zhaoxiaoping
 * @date 2024-6-14
 */
public class NumberGameV2 {
  public static String input(int num) {
    Rule fizzBuzzRule = SimpleRuleEngine.atom(times(3).and(times(5)), n -> "FizzBuzz");
    Rule fizzRule = SimpleRuleEngine.atom(times(3), n -> "Fizz");
    Rule buzzRule = SimpleRuleEngine.atom(times(5), n -> "Buzz");
    Rule defaultRule = SimpleRuleEngine.atom(n -> true, n -> String.valueOf(n));
    // fizzBuzzRule 与 compositeFizzBuzzRule 效果一样
    Rule compositeFizzBuzzRule = SimpleRuleEngine.allOf(fizzRule, buzzRule);

    Rule rule = SimpleRuleEngine.anyOf(compositeFizzBuzzRule, fizzRule, buzzRule, defaultRule);
    return rule.apply(num);
  }

  public static Condition times(int i) {
    return n -> n % i == 0;
  }
}
