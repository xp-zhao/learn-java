package org.learn.spring.beans.factory.annotation;

import cn.hutool.core.bean.BeanUtil;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.PropertyValues;
import org.learn.spring.beans.factory.BeanFactory;
import org.learn.spring.beans.factory.BeanFactoryAware;
import org.learn.spring.beans.factory.ConfigurableListableBeanFactory;
import org.learn.spring.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.learn.spring.util.ClassUtils;

import java.lang.reflect.Field;

/**
 * 处理 @Value, @Autowired 注解的 BeanPostProcessor
 *
 * @author zhaoxiaoping
 * @date 2023-2-27
 */
public class AutowiredAnnotationBeanPostProcessor
    implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

  private ConfigurableListableBeanFactory beanFactory;

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
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

  @Override
  public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName)
      throws BeansException {
    return null;
  }

  @Override
  public PropertyValues postProcessPropertyValues(
      PropertyValues pvs, Object bean, String beanName) {
    Class<?> clazz = bean.getClass();
    clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
    Field[] declaredFields = clazz.getDeclaredFields();
    // 处理 @Value 注解
    for (Field field : declaredFields) {
      Value valueAnnotation = field.getAnnotation(Value.class);
      if (null != valueAnnotation) {
        String value = valueAnnotation.value();
        value = beanFactory.resolveEmbeddedValue(value);
        BeanUtil.setFieldValue(bean, field.getName(), value);
      }
    }
    // 处理 @Autowired 注解
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
}
