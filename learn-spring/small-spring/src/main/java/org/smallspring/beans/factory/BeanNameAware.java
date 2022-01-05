package org.smallspring.beans.factory;

/**
 * BeanName 感知接口
 *
 * @author xp-zhao
 * @date 2022/1/5
 */
public interface BeanNameAware extends Aware {
  /**
   * 设置bean名称
   *
   * @param name 名字
   */
  void setBeanName(String name);
}
