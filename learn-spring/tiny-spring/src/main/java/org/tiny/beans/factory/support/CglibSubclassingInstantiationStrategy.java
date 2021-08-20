package org.tiny.beans.factory.support;

import java.lang.reflect.Constructor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.tiny.beans.factory.config.BeanDefinition;

/** @author zhaoxiaoping @Description: cglib 实例化 @Date 2021-8-20 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
  @Override
  public Object instantiate(
      BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(beanDefinition.getBeanClass());
    enhancer.setCallback(
        new NoOp() {
          @Override
          public int hashCode() {
            return super.hashCode();
          }
        });
    if (null == ctor) {
      return enhancer.create();
    }
    return enhancer.create(ctor.getParameterTypes(), args);
  }
}
