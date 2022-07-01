package java.org.learn.spring.beans.factory.support;

import java.lang.reflect.Constructor;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.config.BeanDefinition;

/**
 * Bean 对象实例化策略接口
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public interface InstantiationStrategy {
  /**
   * 对象实例化
   *
   * @param beanDefinition bean定义
   * @param beanName bean的名字
   * @param ctor 构造函数
   * @param args 构造函数入参
   * @return {@code Object}
   * @throws BeansException 异常
   */
  Object instantiate(
      BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args)
      throws BeansException;
}
