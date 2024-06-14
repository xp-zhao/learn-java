package com.spring.example04.v2;

import java.util.Objects;

/**
 * 判断条件接口
 *
 * @author zhaoxiaoping
 * @date 2024-6-13
 */
@FunctionalInterface
public interface Condition {
  boolean evaluate(int number);

  /** and 逻辑 */
  default Condition and(Condition other) {
    Objects.requireNonNull(other);
    return number -> this.evaluate(number) && other.evaluate(number);
  }

  /** or 逻辑 */
  default Condition or(Condition other) {
    Objects.requireNonNull(other);
    return number -> this.evaluate(number) || other.evaluate(number);
  }
}
