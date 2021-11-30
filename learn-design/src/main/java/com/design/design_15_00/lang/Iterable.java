package com.design.design_15_00.lang;

/**
 * 可迭代接口
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public interface Iterable<E> {
  /**
   * 迭代器
   *
   * @return {@code Iterator<E>}
   */
  Iterator<E> iterator();
}
