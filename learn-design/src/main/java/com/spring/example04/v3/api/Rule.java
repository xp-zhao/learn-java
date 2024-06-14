package com.spring.example04.v3.api;

/**
 * 规则接口 ( if(Condition) then do(Action))
 *
 * @author zhaoxiaoping
 * @date 2024-6-13
 */
public interface Rule extends Comparable<Rule> {
  /** Default rule name. */
  String DEFAULT_NAME = "rule";

  /** Default rule description. */
  String DEFAULT_DESCRIPTION = "description";

  /** Default rule priority. */
  int DEFAULT_PRIORITY = Integer.MAX_VALUE - 1;

  default String getName() {
    return DEFAULT_NAME;
  }

  default String getDescription() {
    return DEFAULT_DESCRIPTION;
  }

  default int getPriority() {
    return DEFAULT_PRIORITY;
  }

  boolean evaluate(Facts facts);

  void execute(Facts facts);

  boolean apply(Facts facts);
}
