package org.tiny.beans.factory;

import java.util.Map;
import org.tiny.beans.BeansException;

/** @author zhaoxiaoping @Description: 可以返回批量信息的 bean 对象工厂 @Date 2021-8-24 */
public interface ListableBeanFactory extends BeanFactory {

  /**
   * 按照类型返回 Bean 实例
   *
   * @param type bean 类型
   * @param <T> 泛型
   * @return key: bean 名称, value: Bean 实例
   * @throws BeansException 异常抛出
   */
  <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

  /**
   * 获取注册的所有的 Bean 名称
   *
   * @return Bean 名称数组
   */
  String[] getBeanDefinitionNames();
}
