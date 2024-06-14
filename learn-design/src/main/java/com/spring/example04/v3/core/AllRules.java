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
public class AllRules extends CompositeRule {

  public static CompositeRule allOf(Rule... rules) {
    CompositeRule instance = new AllRules();
    Collections.addAll(instance.rules, rules);
    return instance;
  }

  @Override
  protected boolean doApply(Facts facts) {
    log.debug("start AND composite rule apply");
    if (evaluate(facts)) {
      for (Rule rule : rules) {
        rule.execute(facts);
      }
      return true;
    }
    return false;
  }

  @Override
  public boolean evaluate(Facts facts) {
    if (rules.stream().allMatch(rule -> rule.evaluate(facts))) {
      return true;
    }
    return false;
  }

  @Override
  public void execute(Facts facts) {
    for (Rule rule : rules) {
      rule.execute(facts);
    }
  }
}
