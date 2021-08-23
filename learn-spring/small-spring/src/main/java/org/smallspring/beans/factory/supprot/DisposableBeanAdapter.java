package org.smallspring.beans.factory.supprot;

import cn.hutool.core.util.StrUtil;
import java.lang.reflect.Method;
import org.smallspring.beans.BeansException;
import org.smallspring.beans.factory.DisposableBean;
import org.smallspring.beans.factory.config.BeanDefinition;

/** @author zhaoxiaoping @Description: @Date 2021-8-23 */
public class DisposableBeanAdapter implements DisposableBean {

  private final Object bean;
  private final String beanName;
  private String destroyMethodName;

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
        && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
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
