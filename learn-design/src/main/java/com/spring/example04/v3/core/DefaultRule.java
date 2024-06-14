package com.spring.example04.v3.core;

import com.spring.example04.v3.api.Action;
import com.spring.example04.v3.api.Condition;
import com.spring.example04.v3.api.Facts;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxiaoping
 * @date 2024-6-14
 */
public class DefaultRule extends AbstractRule {
  private final Condition condition;
  private final List<Action> actions;

  public DefaultRule(Condition condition, Action action) {
    this.condition = condition;
    this.actions = new ArrayList<>();
    this.actions.add(action);
  }

  public DefaultRule(Condition condition, List<Action> actions) {
    this.condition = condition;
    this.actions = actions;
  }

  public DefaultRule(
      String name, String description, int priority, Condition condition, List<Action> actions) {
    super(name, description, priority);
    this.condition = condition;
    this.actions = actions;
  }

  @Override
  public boolean evaluate(Facts facts) {
    return condition.evaluate(facts);
  }

  @Override
  public void execute(Facts facts) {
    for (Action action : actions) {
      action.execute(facts);
    }
  }

  @Override
  public boolean apply(Facts facts) {
    if (condition.evaluate(facts)) {
      for (Action action : actions) {
        action.execute(facts);
      }
      return true;
    }
    return false;
  }
}
