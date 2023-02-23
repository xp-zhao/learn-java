package org.learn.spring.aop;

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
    return this.target.getClass().getInterfaces();
  }

  public Object getTarget() {
    return target;
  }
}
