package com.spring.example04.v3.api;

import java.util.Objects;

/**
 * 判断条件接口
 *
 * @author zhaoxiaoping
 * @date 2024-6-13
 */
@FunctionalInterface
public interface Condition {
  boolean evaluate(Facts facts);

  /** and 逻辑 */
  default Condition and(Condition other) {
    Objects.requireNonNull(other);
    return facts -> this.evaluate(facts) && other.evaluate(facts);
  }

  /** or 逻辑 */
  default Condition or(Condition other) {
    Objects.requireNonNull(other);
    return facts -> this.evaluate(facts) || other.evaluate(facts);
  }

  Condition FALSE = facts -> false;

  Condition TRUE = facts -> true;
}
