package org.learn.spring.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.DisposableBean;
import org.learn.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * Bean 销毁方法适配器
 *
 * @author zhaoxiaoping
 * @date 2023-2-7
 */
public class DisposableBeanAdapter implements DisposableBean {

  private final Object bean;
  private final String beanName;
  private final String destroyMethodName;

  public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
    this.bean = bean;
    this.beanName = beanName;
    this.destroyMethodName = beanDefinition.getDestroyMethodName();
  }

  @Override
  public void destroy() throws Exception {
    if (bean instanceof DisposableBean) {
      ((DisposableBean) bean).destroy();
    }
    if (StrUtil.isNotEmpty(destroyMethodName)
        && !(bean instanceof DisposableBean && "destory".equals(this.destroyMethodName))) {
      Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
      if (null == destroyMethod) {
        throw new BeansException(
            "Couldn't find a destroy method named '"
                + destroyMethodName
                + "' on bean with name '"
                + beanName
                + "'");
      }
      destroyMethod.invoke(bean);
    }
  }
}
