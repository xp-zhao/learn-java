package com.spring.example04.v2;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 简单的规则引擎
 *
 * @author zhaoxiaoping
 * @date 2024-6-13
 */
public class SimpleRuleEngine {
  public static Rule atom(Condition condition, Action action) {
    return n -> condition.evaluate(n) ? action.execute(n) : "";
  }

  public static Rule anyOf(Rule... rules) {
    return n -> stringStream(n, rules).filter(s -> !s.isEmpty()).findFirst().get();
  }

  public static Rule allOf(Rule... rules) {
    return n -> stringStream(n, rules).collect(Collectors.joining());
  }

  public static Stream<String> stringStream(int n, Rule[] rules) {
    return Arrays.stream(rules).map(r -> r.apply(n));
  }
}
