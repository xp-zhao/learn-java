package com.spring.example04.v2;

/**
 * 执行动作接口
 *
 * @author zhaoxiaoping
 * @date 2024-6-13
 */
@FunctionalInterface
public interface Action {
  String execute(int number);
}
