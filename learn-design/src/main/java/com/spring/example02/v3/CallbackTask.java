package com.spring.example02.v3;

/**
 * 回调接口
 *
 * @author zhaoxiaoping
 * @date 2024-3-27
 */
public interface CallbackTask<R> {
  /** 目标任务需要实现的主方法 */
  R execute();

  /** 方法执行成功后的回调 */
  default void onSuccess(R r) {}

  /** 方法执行失败后的回调 */
  default void onFailure(Throwable t) {}
}
