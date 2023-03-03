package com.example.feature.concurrent;

import java.util.List;

/**
 * 回调接口
 *
 * @author zhaoxiaoping
 * @date 2023-3-2
 */
public interface Processor<T> {
  void process(List<T> list);
}
