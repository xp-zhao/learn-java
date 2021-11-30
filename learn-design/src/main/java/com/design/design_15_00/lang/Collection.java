package com.design.design_15_00.lang;

/**
 * 集合接口
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public interface Collection<E, L> extends Iterable<E> {
  /**
   * 添加
   *
   * @param e e
   * @return boolean
   */
  boolean add(E e);

  /**
   * 删除
   *
   * @param e e
   * @return boolean
   */
  boolean remove(E e);

  /**
   * 添加链接
   *
   * @param key 关键
   * @param l l
   * @return boolean
   */
  boolean addLink(String key, L l);

  /**
   * 删除链接
   *
   * @param key 关键
   * @return boolean
   */
  boolean removeLink(String key);
}
