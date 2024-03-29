package org.learn.spring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.TypeUtil;
import lombok.extern.slf4j.Slf4j;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.PropertyValue;
import org.learn.spring.beans.PropertyValues;
import org.learn.spring.beans.factory.*;
import org.learn.spring.beans.factory.config.*;
import org.learn.spring.core.convert.ConversionService;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * BeanFactory 抽象类, 负责实例化 Bean 对象
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
@Slf4j
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory
    implements AutowireCapableBeanFactory {

  /** 对象实例化策略, 默认 cglib 策略 */
  private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();
//    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

  @Override
  public Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
    // 判断是否需要返回代理对象
    Object bean = resolveBeforeInstantiation(beanName, beanDefinition);
    if (bean != null) {
      return bean;
    }
    return doCreateBean(beanName, beanDefinition, args);
  }

  protected Object doCreateBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
    Object bean = null;
    try {
      // 实例化 bean
      bean = createBeanInstance(beanDefinition, beanName, args);
      // 处理循环依赖, 将实例化之后的 Bean 对象提前放入缓存中
      if (beanDefinition.isSingleton()) {
        Object finalBean = bean;
        addSingletonFactory(
            beanName, () -> getEarlyBeanReference(beanName, beanDefinition, finalBean));
      }
      // BeanPostProcessor 修改属性值
      applyBeanPostProcessorsBeforeApplyingPropertyValues(beanName, bean, beanDefinition);
      // 给 bean 对象填充属性
      applyPropertyValue(beanName, bean, beanDefinition);
      // 执行 bean 对象的初始化方法和 BeanPostProcess 的前置后置方法
      bean = initializeBean(beanName, bean, beanDefinition);
    } catch (Exception e) {
      throw new BeansException("Instantiation of bean failed", e);
    }
    // 注册实现了 DisposableBean 接口的 Bean 对象
    registerDisposableBeanIfNecessary(beanName, bean, beanDefinition);
    Object exposedObject = bean;
    if (beanDefinition.isSingleton()) {
      exposedObject = getSingleton(beanName);
      // 注册单例对象
      registerSingleton(beanName, bean);
    }
    return exposedObject;
  }

  protected Object getEarlyBeanReference(
      String beanName, BeanDefinition beanDefinition, Object bean) {
    Object exposedObject = bean;
    for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
      if (beanPostProcessor instanceof InstantiationAwareBeanPostProcessor) {
        exposedObject =
            ((InstantiationAwareBeanPostProcessor) beanPostProcessor)
                .getEarlyBeanReference(bean, beanName);
        if (null == exposedObject) {
          return exposedObject;
        }
      }
    }
    return exposedObject;
  }

  protected void applyBeanPostProcessorsBeforeApplyingPropertyValues(
      String beanName, Object bean, BeanDefinition beanDefinition) {
    for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
      if (beanPostProcessor instanceof InstantiationAwareBeanPostProcessor) {
        PropertyValues pvs =
            ((InstantiationAwareBeanPostProcessor) beanPostProcessor)
                .postProcessPropertyValues(beanDefinition.getPropertyValues(), bean, beanName);
        if (null != pvs) {
          PropertyValues propertyValues = beanDefinition.getPropertyValues();
          for (PropertyValue propertyValue : pvs.getPropertyValues()) {
            beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
          }
        }
      }
    }
  }

  protected Object resolveBeforeInstantiation(String beanName, BeanDefinition beanDefinition) {
    Object bean =
        applyBeanPostProcessorsBeforeInstantiation(beanDefinition.getBeanClass(), beanName);
    if (bean != null) {
      bean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
    }
    return bean;
  }

  protected Object applyBeanPostProcessorsBeforeInstantiation(Class<?> beanClass, String beanName) {
    for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
      if (beanPostProcessor instanceof InstantiationAwareBeanPostProcessor) {
        Object obj =
            ((InstantiationAwareBeanPostProcessor) beanPostProcessor)
                .postProcessBeforeInstantiation(beanClass, beanName);
        if (obj != null) {
          return obj;
        }
      }
    }
    return null;
  }

  protected void registerDisposableBeanIfNecessary(
      String beanName, Object bean, BeanDefinition beanDefinition) {
    // 非 Singleton 类型的对象, 不执行销毁方法
    if (!beanDefinition.isSingleton()) {
      return;
    }
    if (bean instanceof DisposableBean
        || StrUtil.isNotEmpty(beanDefinition.getDestroyMethodName())) {
      registerDisposableBean(beanName, new DisposableBeanAdapter(bean, beanName, beanDefinition));
    }
  }

  protected Object createBeanInstance(
      BeanDefinition beanDefinition, String beanName, Object[] args) {
    Constructor constructorToUse = null;
    Class beanClass = beanDefinition.getBeanClass();
    Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();
    for (Constructor declaredConstructor : declaredConstructors) {
      if (null != args && declaredConstructor.getParameterTypes().length == args.length) {
        constructorToUse = declaredConstructor;
        break;
      }
    }
    return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
  }

  /**
   * 填充对象属性
   *
   * @param beanName
   * @param bean
   * @param beanDefinition
   */
  protected void applyPropertyValue(String beanName, Object bean, BeanDefinition beanDefinition) {
    try {
      PropertyValues propertyValues = beanDefinition.getPropertyValues();
      for (PropertyValue pv : propertyValues.getPropertyValues()) {
        String name = pv.getName();
        Object value = pv.getValue();
        if (value instanceof BeanReference) {
          // 对象属性是另一个对象的引用
          BeanReference beanReference = (BeanReference) value;
          value = getBean(beanReference.getBeanName());
        } else {
          Class<?> sourceType = value.getClass();
          Class<?> targetType = (Class<?>) TypeUtil.getFieldType(bean.getClass(), name);
          ConversionService conversionService = getConversionService();
          if (conversionService != null) {
            if (conversionService.canConvert(sourceType, targetType)) {
              value = conversionService.convert(value, targetType);
            }
          }
        }
        // 属性填充
        BeanUtil.setFieldValue(bean, name, value);
      }
    } catch (Exception e) {
      log.error("Error setting property values", e);
      throw new BeansException("Error setting property values：" + beanName);
    }
  }

  public InstantiationStrategy getInstantiationStrategy() {
    return instantiationStrategy;
  }

  public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
    this.instantiationStrategy = instantiationStrategy;
  }

  private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
    if (bean instanceof Aware) {
      if (bean instanceof BeanFactoryAware) {
        ((BeanFactoryAware) bean).setBeanFactory(this);
      }
      if (bean instanceof BeanClassLoaderAware) {
        ((BeanClassLoaderAware) bean).setBeanClassLoader(getBeanClassLoader());
      }
      if (bean instanceof BeanNameAware) {
        ((BeanNameAware) bean).setBeanName(beanName);
      }
    }
    // 执行前置方法
    Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);
    // 执行初始化方法
    try {
      invokeInitMethods(beanName, bean, beanDefinition);
    } catch (Exception e) {
      throw new BeansException("Invocation of init method of bean[" + beanName + "] failed", e);
    }
    // 执行后置方法
    wrappedBean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
    return wrappedBean;
  }

  private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition)
      throws Exception {
    if (wrappedBean instanceof InitializingBean) {
      ((InitializingBean) wrappedBean).afterPropertiesSet();
    }
    String initMethodName = beanDefinition.getInitMethodName();
    if (StrUtil.isNotEmpty(initMethodName)) {
      Method initMethod = beanDefinition.getBeanClass().getMethod(initMethodName);
      if (null == initMethod) {
        throw new BeansException(
            "Could not find an init method named '"
                + initMethodName
                + "' on bean with name '"
                + beanName
                + "'");
      }
      initMethod.invoke(wrappedBean);
    }
  }

  @Override
  public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
      throws BeansException {
    Object result = existingBean;
    for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
      Object current = beanPostProcessor.postProcessBeforeInitialization(result, beanName);
      if (null == current) {
        return result;
      }
      result = current;
    }
    return result;
  }

  @Override
  public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
      throws BeansException {
    Object result = existingBean;
    for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
      Object current = beanPostProcessor.postProcessAfterInitialization(result, beanName);
      if (null == current) {
        return result;
      }
      result = current;
    }
    return result;
  }
}
