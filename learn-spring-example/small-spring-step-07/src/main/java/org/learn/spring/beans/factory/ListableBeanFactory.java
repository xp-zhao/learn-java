package org.learn.spring.beans.factory;

import java.util.Map;
import org.learn.spring.beans.BeansException;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/1/4
 */
public interface ListableBeanFactory extends BeanFactory {
  /**
   * 按照类型返回 Bean 实例
   *
   * @param type 类型
   * @return {@link Map}<{@link String}, {@link T}>
   * @throws BeansException 豆子例外
   */
  <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;
  /**
   * 返回注册表中所有的Bean名称
   *
   * @return {@link String[]}
   */
  String[] getBeanDefinitionNames();
}
