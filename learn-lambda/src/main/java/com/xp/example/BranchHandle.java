package com.xp.example;

/**
 * 分支处理接口
 *
 * @author zhaoxiaoping
 * @date 2021-11-24
 */
@FunctionalInterface
public interface BranchHandle {
  /**
   * 分支操作
   *
   * @param trueHandle 为 true 的处理
   * @param falseHandle 为 false 的处理
   */
  void trueOrFalseHandle(Runnable trueHandle, Runnable falseHandle);
}
