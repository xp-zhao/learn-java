package java.org.learn.spring.beans.factory;

import org.learn.spring.beans.BeansException;

/**
 * 所属 BeanFactory 感知接口
 *
 * @author zhaoxiaoping
 * @date 2022-1-6
 */
public interface BeanFactoryAware extends Aware {
  /**
   * 设置bean工厂
   *
   * @param beanFactory bean工厂
   * @throws BeansException 异常
   */
  void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
