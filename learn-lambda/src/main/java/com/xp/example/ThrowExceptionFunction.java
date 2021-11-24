package com.xp.example;

/**
 * 抛出异常的接口
 *
 * @author zhaoxiaoping
 * @date 2021-11-24
 */
@FunctionalInterface
public interface ThrowExceptionFunction {
  /**
   * 抛出异常消息
   *
   * @param message 消息
   */
  void throwMessage(String message);
}
