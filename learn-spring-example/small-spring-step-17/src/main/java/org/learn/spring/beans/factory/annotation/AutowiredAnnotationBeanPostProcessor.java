package org.learn.spring.beans.factory.annotation;

import cn.hutool.core.bean.BeanUtil;
import java.lang.reflect.Field;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.PropertyValues;
import org.learn.spring.beans.factory.BeanFactory;
import org.learn.spring.beans.factory.BeanFactoryAware;
import org.learn.spring.beans.factory.ConfigurableListableBeanFactory;
import org.learn.spring.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.learn.spring.util.ClassUtils;

/**
 * 处理 @Value、@Autowired，注解的 BeanPostProcessor
 *
 * @author zhaoxiaoping
 * @date 2022-5-7
 */
public class AutowiredAnnotationBeanPostProcessor
    implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

  private ConfigurableListableBeanFactory beanFactory;

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
  }

  @Override
  public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName)
      throws BeansException {
    return null;
  }

  @Override
  public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
    return true;
  }

  @Override
  public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName)
      throws BeansException {
    // 1. 处理注解 @Value
    Class<?> clazz = bean.getClass();
    clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
    Field[] declaredFields = clazz.getDeclaredFields();
    for (Field field : declaredFields) {
      Value valueAnnotation = field.getAnnotation(Value.class);
      if (null != valueAnnotation) {
        String value = valueAnnotation.value();
        value = beanFactory.resolveEmbeddedValue(value);
        BeanUtil.setFieldValue(bean, field.getName(), value);
      }
    }
    // 2. 处理注解 @Autowired
    for (Field field : declaredFields) {
      Autowired autowiredAnnotation = field.getAnnotation(Autowired.class);
      if (null != autowiredAnnotation) {
        Class<?> fieldType = field.getType();
        String dependentBeanName = null;
        Qualifier qualifierAnnotation = field.getAnnotation(Qualifier.class);
        Object dependentBean = null;
        if (null != qualifierAnnotation) {
          dependentBeanName = qualifierAnnotation.value();
          dependentBean = beanFactory.getBean(dependentBeanName, fieldType);
        } else {
          dependentBean = beanFactory.getBean(fieldType);
        }
        BeanUtil.setFieldValue(bean, field.getName(), dependentBean);
      }
    }

    return pvs;
  }

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    return null;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    return null;
  }
}
