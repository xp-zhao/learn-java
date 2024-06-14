package com.spring.example04.v3.core;

import com.spring.example04.v3.api.Facts;
import com.spring.example04.v3.api.Rule;
import com.spring.example04.v3.api.RuleEngine;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @date 2024-6-14
 */
@Slf4j
public class DefaultRuleEngine implements RuleEngine {
  @Override
  public void fire(Rule rule, Facts facts) {
    if (rule == null) {
      log.error("Rules is null! Nothing to apply");
      return;
    }
    rule.apply(facts);
  }
}
