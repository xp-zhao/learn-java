package com.spring.example05.v2;

import com.spring.example05.v2.context.BaseProcessContext;

/**
 * 执行任务接口
 *
 * @author zhaoxiaoping
 * @date 2024-8-6
 */
public interface Task<T extends BaseProcessContext> {
  /** 执行当前任务的处理逻辑 */
  T execute(T context);
}
