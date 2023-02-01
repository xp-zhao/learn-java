package org.learn.spring.beans.factory.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * cglib 实例化策略
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
  @Override
  public Object instantiate(
      BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args)
      throws BeansException {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(beanDefinition.getBeanClass());
    enhancer.setCallback(
        new NoOp() {
          @Override
          public int hashCode() {
            return super.hashCode();
          }
        });
    if (null == constructor) {
      return enhancer.create();
    }
    return enhancer.create(constructor.getParameterTypes(), args);
  }
}
