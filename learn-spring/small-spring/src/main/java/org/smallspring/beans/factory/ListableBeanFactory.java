package org.smallspring.beans.factory;

import java.util.Map;
import org.smallspring.beans.BeansException;

/** @author zhaoxiaoping @Description: @Date 2021-8-17 */
public interface ListableBeanFactory extends BeanFactory {
  /**
   * 按照类型返回 Bean 实例
   *
   * @param type
   * @param <T>
   * @return
   * @throws BeansException
   */
  <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

  /**
   * Return the names of all beans defined in this registry.
   *
   * @return 注册表中所有的Bean名称
   */
  String[] getBeanDefinitionNames();
}
