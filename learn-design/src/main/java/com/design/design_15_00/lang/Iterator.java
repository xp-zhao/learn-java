package com.design.design_15_00.lang;

/**
 * 迭代器接口
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public interface Iterator<E> {
  /**
   * 是否有下一个元素
   *
   * @return boolean
   */
  boolean hasNext();

  /**
   * 下一个
   *
   * @return {@code E}
   */
  E next();
}
