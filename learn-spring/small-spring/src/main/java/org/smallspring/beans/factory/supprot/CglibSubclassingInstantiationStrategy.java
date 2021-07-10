package org.smallspring.beans.factory.supprot;

import java.lang.reflect.Constructor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.smallspring.beans.factory.config.BeanDefinition;

/**
 * @author zhaoxiaoping
 * @Description: Cglib 实例化
 * @Date 2021-7-10
 **/
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

  @Override
  public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor,
      Object[] args) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(beanDefinition.getBeanClass());
    enhancer.setCallback(new NoOp() {
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
