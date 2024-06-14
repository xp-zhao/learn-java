package com.spring.example04.v3.core;

import com.spring.example04.v3.api.Action;
import com.spring.example04.v3.api.Condition;
import com.spring.example04.v3.api.Rule;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxiaoping
 * @date 2024-6-14
 */
public class RuleBuilder {
  private String name = Rule.DEFAULT_NAME;
  private String description = Rule.DEFAULT_DESCRIPTION;
  private int priority = Rule.DEFAULT_PRIORITY;

  private Condition condition = Condition.FALSE;
  private final List<Action> actions = new ArrayList<>();

  public RuleBuilder name(String name) {
    this.name = name;
    return this;
  }

  public RuleBuilder description(String description) {
    this.description = description;
    return this;
  }

  public RuleBuilder priority(int priority) {
    this.priority = priority;
    return this;
  }

  public RuleBuilder when(Condition condition) {
    this.condition = condition;
    return this;
  }

  public RuleBuilder then(Action action) {
    this.actions.add(action);
    return this;
  }

  public Rule build() {
    return new DefaultRule(name, description, priority, condition, actions);
  }
}
