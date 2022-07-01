package java.org.learn.spring.aop.framework.autoproxy;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.learn.spring.aop.AdvisedSupport;
import org.learn.spring.aop.Advisor;
import org.learn.spring.aop.ClassFilter;
import org.learn.spring.aop.Pointcut;
import org.learn.spring.aop.TargetSource;
import org.learn.spring.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.learn.spring.aop.framework.ProxyFactory;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.PropertyValues;
import org.learn.spring.beans.factory.BeanFactory;
import org.learn.spring.beans.factory.BeanFactoryAware;
import org.learn.spring.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.learn.spring.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author zhaoxiaoping
 * @date 2022-2-16
 */
public class DefaultAdvisorAutoProxyCreator
    implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

  private DefaultListableBeanFactory beanFactory;
  private final Set<Object> earlyProxyReferences =
      Collections.synchronizedSet(new HashSet<Object>());

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.beanFactory = (DefaultListableBeanFactory) beanFactory;
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
    return pvs;
  }

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    if (!earlyProxyReferences.contains(beanName)) {
      return wrapIfNecessary(bean, beanName);
    }
    return bean;
  }

  @Override
  public Object getEarlyBeanReference(Object bean, String beanName) {
    earlyProxyReferences.add(beanName);
    return wrapIfNecessary(bean, beanName);
  }

  protected Object wrapIfNecessary(Object bean, String beanName) {
    if (isInfrastructureClass(bean.getClass())) {
      return bean;
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
      advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
      advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
      advisedSupport.setProxyTargetClass(true);
      // 返回代理对象
      return new ProxyFactory(advisedSupport).getProxy();
    }
    return bean;
  }

  private boolean isInfrastructureClass(Class<?> beanClass) {
    return Advice.class.isAssignableFrom(beanClass)
        || Pointcut.class.isAssignableFrom(beanClass)
        || Advisor.class.isAssignableFrom(beanClass);
  }
}
