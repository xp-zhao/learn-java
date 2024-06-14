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
public class NaturalRules extends CompositeRule {
  public static CompositeRule of(Rule... rules) {
    CompositeRule instance = new NaturalRules();
    Collections.addAll(instance.rules, rules);
    return instance;
  }

  @Override
  protected boolean doApply(Facts facts) {
    log.debug("start Natural composite rule apply");
    for (Rule rule : rules) {
      rule.apply(facts);
    }
    return true;
  }

  @Override
  public boolean evaluate(Facts facts) {
    // 不支持, which means Natural Rules can not be the children of other rules
    throw new RuntimeException("evaluate not supported for natural composite");
  }

  @Override
  public void execute(Facts facts) {
    // 不支持, which means Natural Rules can not be the children of other rules
    throw new RuntimeException("execute not supported for natural composite");
  }
}
