package com.spring.example04.v3.core;

import com.spring.example04.v3.api.Facts;
import com.spring.example04.v3.api.Rule;
import java.util.Objects;

/**
 * @author zhaoxiaoping
 * @date 2024-6-14
 */
public abstract class AbstractRule implements Rule {

  protected String name;
  protected String description;
  protected int priority;

  public AbstractRule() {
    this(Rule.DEFAULT_NAME, Rule.DEFAULT_DESCRIPTION, Rule.DEFAULT_PRIORITY);
  }

  public AbstractRule(final String name) {
    this(name, Rule.DEFAULT_DESCRIPTION, Rule.DEFAULT_PRIORITY);
  }

  public AbstractRule(final int priority) {
    this(Rule.DEFAULT_NAME, Rule.DEFAULT_DESCRIPTION, priority);
  }

  public AbstractRule(final String name, final String description) {
    this(name, description, Rule.DEFAULT_PRIORITY);
  }

  public AbstractRule(final String name, final String description, final int priority) {
    this.name = name;
    this.description = description;
    this.priority = priority;
  }

  public abstract boolean evaluate(Facts facts);

  public abstract void execute(Facts facts);

  public abstract boolean apply(Facts facts);

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(final int priority) {
    this.priority = priority;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AbstractRule basicRule = (AbstractRule) o;

    if (priority != basicRule.priority) return false;
    if (!name.equals(basicRule.name)) return false;
    return Objects.equals(description, basicRule.description);
  }

  @Override
  public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + (description != null ? description.hashCode() : 0);
    result = 31 * result + priority;
    return result;
  }

  @Override
  public String toString() {
    return name + ":" + priority;
  }

  @Override
  public int compareTo(final Rule rule) {
    if (getPriority() < rule.getPriority()) {
      return -1;
    } else if (getPriority() > rule.getPriority()) {
      return 1;
    }
    return 0;
  }
}
