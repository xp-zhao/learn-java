package com.spring.example04.v2;

/**
 * 规则接口 ( if(Condition) then do(Action))
 *
 * @author zhaoxiaoping
 * @date 2024-6-13
 */
@FunctionalInterface
public interface Rule {
  String apply(int number);
}
