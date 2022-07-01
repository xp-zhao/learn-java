package java.org.learn.spring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.PropertyValue;
import org.learn.spring.beans.PropertyValues;
import org.learn.spring.beans.factory.Aware;
import org.learn.spring.beans.factory.BeanClassLoaderAware;
import org.learn.spring.beans.factory.BeanFactoryAware;
import org.learn.spring.beans.factory.BeanNameAware;
import org.learn.spring.beans.factory.DisposableBean;
import org.learn.spring.beans.factory.InitializingBean;
import org.learn.spring.beans.factory.config.AutowireCapableBeanFactory;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.beans.factory.config.BeanPostProcessor;
import org.learn.spring.beans.factory.config.BeanReference;
import org.learn.spring.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * 抽象的实例化 Bean 对象工厂类
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory
    implements AutowireCapableBeanFactory {

  /** 对象实例化策略 */
  private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

  @Override
  protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args)
      throws BeansException {
    // 判断是否返回代理 bean 对象
    Object bean = resolveBeforeInstantiation(beanName, beanDefinition);
    if (null != bean) {
      return bean;
    }
    return doCreateBean(beanName, beanDefinition, args);
  }

  protected Object doCreateBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
    Object bean;
    try {
      // 实例化 bean
      bean = createBeanInstance(beanDefinition, beanName, args);

      // 处理循环依赖，将实例化后的Bean对象提前放入缓存中暴露出来
      if (beanDefinition.isSingleton()) {
        Object finalBean = bean;
        addSingletonFactory(
            beanName, () -> getEarlyBeanReference(beanName, beanDefinition, finalBean));
      }

      // 实例化后判断
      boolean continueWithPropertyPopulation =
          applyBeanPostProcessorsAfterInstantiation(beanName, bean);
      if (!continueWithPropertyPopulation) {
        return bean;
      }
      // 在设置 Bean 属性之前，允许 BeanPostProcessor 修改属性值
      applyBeanPostProcessorsBeforeApplyingPropertyValues(beanName, bean, beanDefinition);
      // 给 Bean 填充属性
      applyPropertyValues(beanName, bean, beanDefinition);
      // 执行 Bean 的初始化方法和 BeanPostProcessor 的前置和后置处理方法
      bean = initializeBean(beanName, bean, beanDefinition);
    } catch (Exception e) {
      throw new BeansException("Instantiation of bean failed", e);
    }

    // 注册实现了 DisposableBean 接口的 Bean 对象
    registerDisposableBeanIfNecessary(beanName, bean, beanDefinition);
    Object exposedObject = bean;
    if (beanDefinition.isSingleton()) {
      // 获取代理对象
      exposedObject = getSingleton(beanName);
      // 注册单例对象
      registerSingleton(beanName, exposedObject);
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
                .getEarlyBeanReference(exposedObject, beanName);
        if (null == exposedObject) {
          return exposedObject;
        }
      }
    }
    return exposedObject;
  }

  /**
   * Bean 实例化后对于返回 false 的对象，不在执行后续设置 Bean 对象属性的操作
   *
   * @param beanName
   * @param bean
   * @return
   */
  private boolean applyBeanPostProcessorsAfterInstantiation(String beanName, Object bean) {
    boolean continueWithPropertyPopulation = true;
    for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
      if (beanPostProcessor instanceof InstantiationAwareBeanPostProcessor) {
        InstantiationAwareBeanPostProcessor instantiationAwareBeanPostProcessor =
            (InstantiationAwareBeanPostProcessor) beanPostProcessor;
        if (!instantiationAwareBeanPostProcessor.postProcessAfterInstantiation(bean, beanName)) {
          continueWithPropertyPopulation = false;
          break;
        }
      }
    }
    return continueWithPropertyPopulation;
  }

  /**
   * 在设置 Bean 属性之前，允许 BeanPostProcessor 修改属性值
   *
   * @param beanName
   * @param bean
   * @param beanDefinition
   */
  protected void applyBeanPostProcessorsBeforeApplyingPropertyValues(
      String beanName, Object bean, BeanDefinition beanDefinition) {
    for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
      if (beanPostProcessor instanceof InstantiationAwareBeanPostProcessor) {
        PropertyValues pvs =
            ((InstantiationAwareBeanPostProcessor) beanPostProcessor)
                .postProcessPropertyValues(beanDefinition.getPropertyValues(), bean, beanName);
        if (null != pvs) {
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
    if (null != bean) {
      bean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
    }
    return bean;
  }

  protected Object applyBeanPostProcessorsBeforeInstantiation(Class<?> beanClass, String beanName) {
    for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
      if (beanPostProcessor instanceof InstantiationAwareBeanPostProcessor) {
        Object result =
            ((InstantiationAwareBeanPostProcessor) beanPostProcessor)
                .postProcessBeforeInstantiation(beanClass, beanName);
        if (null != result) {
          return result;
        }
      }
    }
    return null;
  }

  protected void registerDisposableBeanIfNecessary(
      String beanName, Object bean, BeanDefinition beanDefinition) {
    // 非 Singleton 类型的 Bean 不执行销毁方法
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
    Class<?> beanClass = beanDefinition.getBeanClass();
    Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
    for (Constructor ctor : declaredConstructors) {
      if (null != args && ctor.getParameterTypes().length == args.length) {
        constructorToUse = ctor;
        break;
      }
    }
    return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
  }

  /**
   * Bean 属性填充
   *
   * @param beanName bean的名字
   * @param bean 对象实例
   * @param beanDefinition bean定义
   */
  protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
    try {
      PropertyValues propertyValues = beanDefinition.getPropertyValues();
      for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
        String name = propertyValue.getName();
        Object value = propertyValue.getValue();
        if (value instanceof BeanReference) {
          // A 依赖 B，获取 B 的实例化
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

  private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
    // invokeAwareMethods
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
    // 1. 执行 BeanPostProcessor Before 处理
    Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);
    // 执行 Bean 对象的初始化方法
    try {
      invokeInitMethods(beanName, wrappedBean, beanDefinition);
    } catch (Exception e) {
      e.printStackTrace();
    }
    // 2. 执行 BeanPostProcessor After 处理
    wrappedBean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
    return wrappedBean;
  }

  private void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition)
      throws Exception {
    // 1. 实现接口 InitializingBean
    if (bean instanceof InitializingBean) {
      ((InitializingBean) bean).afterPropertiesSet();
    }
    // 2. 注解配置 init-method
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
      initMethod.invoke(bean);
    }
  }

  public InstantiationStrategy getInstantiationStrategy() {
    return instantiationStrategy;
  }

  public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
    this.instantiationStrategy = instantiationStrategy;
  }

  @Override
  public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
      throws BeansException {
    Object result = existingBean;
    for (BeanPostProcessor processor : getBeanPostProcessors()) {
      Object current = processor.postProcessBeforeInitialization(result, beanName);
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
    for (BeanPostProcessor processor : getBeanPostProcessors()) {
      Object current = processor.postProcessAfterInitialization(result, beanName);
      if (null == current) {
        return result;
      }
      result = current;
    }
    return result;
  }
}
