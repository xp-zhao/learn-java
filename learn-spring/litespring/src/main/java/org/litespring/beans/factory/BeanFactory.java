package org.litespring.beans.factory;

/**
 * @author xp-zhao
 * @date 2018/7/8
 */
public interface BeanFactory {

  /**
   * 通过 beanId 获取 bean 对象
   *
   * @param beanId beanId
   * @return bean 对象
   */
  Object getBean(String beanId);
}
