package com.spring.example04.v3.core;

import com.spring.example04.v3.api.Facts;
import com.spring.example04.v3.api.Rule;
import java.util.Collections;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @date 2024-6-14
 */
@Slf4j
public class AnyRules extends CompositeRule {
  public static CompositeRule anyOf(Rule... rules) {
    CompositeRule instance = new AnyRules();
    Collections.addAll(instance.rules, rules);
    return instance;
  }

  @Override
  protected boolean doApply(Facts facts) {
    for (Rule rule : rules) {
      // 短路操作，只要第一个rule成功执行，其它就不执行了
      if (rule.apply(facts)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean evaluate(Facts facts) {
    if (rules.stream().anyMatch(rule -> rule.evaluate(facts))) {
      return true;
    }
    return false;
  }

  @Override
  public void execute(Facts facts) {
    // 不支持OR relation
    throw new RuntimeException("execute not supported for OR relation composite");
  }
}
