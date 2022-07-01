package java.org.learn.spring.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import java.lang.reflect.Method;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.DisposableBean;
import org.learn.spring.beans.factory.config.BeanDefinition;

/**
 * Bean 销毁方法适配器
 *
 * @author zhaoxiaoping
 * @date 2022-1-5
 */
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
    // 1. 实现接口 DisposableBean
    if (bean instanceof DisposableBean) {
      ((DisposableBean) bean).destroy();
    }

    // 2. 注解配置 destroy-method
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
