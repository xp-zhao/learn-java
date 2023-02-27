package org.learn.spring.aop;

import org.learn.spring.util.ClassUtils;

/**
 * 代理的目标对象
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
public class TargetSource {
  private final Object target;

  public TargetSource(Object target) {
    this.target = target;
  }

  public Class<?>[] getTargetClass() {
    Class<?> clazz = this.target.getClass();
    clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
    return clazz.getInterfaces();
  }

  public Object getTarget() {
    return target;
  }
}
