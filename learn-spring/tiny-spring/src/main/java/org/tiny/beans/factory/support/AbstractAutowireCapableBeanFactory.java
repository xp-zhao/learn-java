package org.tiny.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import java.lang.reflect.Constructor;
import org.tiny.beans.BeansException;
import org.tiny.beans.PropertyValue;
import org.tiny.beans.PropertyValues;
import org.tiny.beans.factory.config.BeanDefinition;
import org.tiny.beans.factory.config.BeanReference;

/** @author zhaoxiaoping @Description: 抽象 BeanFactory 子类, 实现创建 bean 的方法 @Date 2021-8-19 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

  /** 对象实例化默认采用 cglib 实例化方式 */
  private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

  @Override
  protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args)
      throws BeansException {
    Object bean;
    try {
      // 实例化 bean
      bean = createBeanInstance(beanDefinition, beanName, args);
      // 设置属性
      applyPropertyValues(beanName, bean, beanDefinition);
    } catch (Exception e) {
      throw new BeansException("实例化 bean 失败", e);
    }
    // 注册单例对象
    addSingleton(beanName, bean);
    return bean;
  }

  protected Object createBeanInstance(
      BeanDefinition beanDefinition, String beanName, Object[] args) {
    Class<?> beanClass = beanDefinition.getBeanClass();
    Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
    Constructor<?> constructorToUse = null;
    for (Constructor<?> constructor : declaredConstructors) {
      if (null != args && constructor.getParameterTypes().length == args.length) {
        constructorToUse = constructor;
        break;
      }
    }
    return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
  }

  /**
   * 为对象填充属性
   *
   * @param beanName bean名称
   * @param bean 对象
   * @param beanDefinition bean定义对象
   */
  protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
    try {
      PropertyValues propertyValues = beanDefinition.getPropertyValues();
      for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
        String name = propertyValue.getName();
        Object value = propertyValue.getValue();
        if (value instanceof BeanReference) {
          // 对象引用, A 依赖 B, 获取 B 的实例化
          BeanReference beanReference = (BeanReference) value;
          value = getBean(beanReference.getBeanName());
        }
        // 属性填充
        BeanUtil.setFieldValue(bean, name, value);
      }
    } catch (Exception e) {
      throw new BeansException("Error setting property values：" + beanName);
    }
  }

  public InstantiationStrategy getInstantiationStrategy() {
    return instantiationStrategy;
  }

  public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
    this.instantiationStrategy = instantiationStrategy;
  }
}
