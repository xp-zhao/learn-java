package org.learn.spring.context.event;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.BeanFactory;
import org.learn.spring.beans.factory.BeanFactoryAware;
import org.learn.spring.context.ApplicationEvent;
import org.learn.spring.context.ApplicationListener;
import org.learn.spring.util.ClassUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 事件广播器抽象类实现
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
public abstract class AbstractApplicationEventMulticaster
    implements ApplicationEventMulticaster, BeanFactoryAware {
  public final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new HashSet<>();

  private BeanFactory beanFactory;

  @Override
  public void addApplicationListener(ApplicationListener<?> listener) {
    applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
  }

  @Override
  public void removeApplicationListener(ApplicationListener<?> listener) {
    applicationListeners.remove(listener);
  }

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.beanFactory = beanFactory;
  }

  protected Collection<ApplicationListener> getApplicationListeners(ApplicationEvent event) {
    LinkedList<ApplicationListener> allListeners = new LinkedList<>();
    for (ApplicationListener<ApplicationEvent> listener : applicationListeners) {
      if (supportsEvent(listener, event)) {
        allListeners.add(listener);
      }
    }
    return allListeners;
  }

  /**
   * 判断监听器与事件是否匹配
   *
   * @param listener
   * @param event
   * @return
   */
  protected boolean supportsEvent(
      ApplicationListener<ApplicationEvent> listener, ApplicationEvent event) {
    Class<? extends ApplicationListener> listenerClass = listener.getClass();
    Class<?> targetClass =
        ClassUtils.isCglibProxyClass(listenerClass) ? listenerClass.getSuperclass() : listenerClass;
    Type genericInterface = targetClass.getGenericInterfaces()[0];
    Type actualTypeArgument = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
    String targetClassName = actualTypeArgument.getTypeName();
    Class<?> targetEventClassName;
    try {
      targetEventClassName = Class.forName(targetClassName);
    } catch (ClassNotFoundException e) {
      throw new BeansException("wrong event class name: " + targetClassName);
    }
    return targetEventClassName.isAssignableFrom(event.getClass());
  }
}
