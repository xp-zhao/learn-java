package org.learn.spring.aop.framework.autoproxy;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.learn.spring.aop.*;
import org.learn.spring.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.learn.spring.aop.framework.ProxyFactory;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.PropertyValues;
import org.learn.spring.beans.factory.BeanFactory;
import org.learn.spring.beans.factory.BeanFactoryAware;
import org.learn.spring.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.learn.spring.beans.factory.support.DefaultListableBeanFactory;

import java.util.Collection;

/**
 * 自动代理创造器
 *
 * @author zhaoxiaoping
 * @date 2023-2-23
 */
public class DefaultAdvisorAutoProxyCreator
    implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

  private DefaultListableBeanFactory beanFactory;

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.beanFactory = (DefaultListableBeanFactory) beanFactory;
  }

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    if (isInfrastructureClass(bean.getClass())) {
      return null;
    }
    Collection<AspectJExpressionPointcutAdvisor> advisors =
        beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
    for (AspectJExpressionPointcutAdvisor advisor : advisors) {
      ClassFilter classFilter = advisor.getPointcut().getClassFilter();
      if (!classFilter.matches(bean.getClass())) {
        continue;
      }
      AdvisedSupport advisedSupport = new AdvisedSupport();
      TargetSource targetSource = new TargetSource(bean);
      advisedSupport.setTargetSource(targetSource);
      advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
      advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
      advisedSupport.setProxyTargetClass(false);
      return new ProxyFactory(advisedSupport).getProxy();
    }
    return bean;
  }

  @Override
  public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName)
      throws BeansException {
    return null;
  }

  @Override
  public PropertyValues postProcessPropertyValues(
      PropertyValues pvs, Object bean, String beanName) {
    return pvs;
  }

  private boolean isInfrastructureClass(Class<?> beanClass) {
    return Advice.class.isAssignableFrom(beanClass)
        || Pointcut.class.isAssignableFrom(beanClass)
        || Advisor.class.isAssignableFrom(beanClass);
  }
}
