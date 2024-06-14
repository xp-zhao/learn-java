package com.spring.example04.v3.core;

import com.spring.example04.v3.api.Facts;
import com.spring.example04.v3.api.Rule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @date 2024-6-14
 */
@Slf4j
public abstract class CompositeRule extends AbstractRule {
  protected List<Rule> rules = new ArrayList<>();

  private boolean isSorted = false;

  public CompositeRule priority(int priority) {
    this.priority = priority;
    return this;
  }

  public CompositeRule name(String name) {
    this.name = name;
    return this;
  }

  public CompositeRule() {}

  @Override
  public boolean apply(Facts facts) {
    sort();
    return doApply(facts);
  }

  protected abstract boolean doApply(Facts facts);

  protected void sort() {
    if (!isSorted) {
      log.debug("{} before sort:{}", this.name, rules);
      Collections.sort(rules);
      log.debug("{} after sort:{}", this.name, rules);
      isSorted = true;
    }
  }
}
