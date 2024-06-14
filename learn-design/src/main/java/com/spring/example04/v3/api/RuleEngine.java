package com.spring.example04.v3.api;

/**
 * @author zhaoxiaoping
 * @date 2024-6-14
 */
public interface RuleEngine {
  void fire(Rule rule, Facts facts);
}
