package org.learn.spring.aop.framework;

import org.learn.spring.aop.AdvisedSupport;

/**
 * 代理工厂
 *
 * @author zhaoxiaoping
 * @date 2023-2-23
 */
public class ProxyFactory {
  private AdvisedSupport advisedSupport;

  public ProxyFactory(AdvisedSupport advisedSupport) {
    this.advisedSupport = advisedSupport;
  }

  public Object getProxy() {
    return createAopProxy().getProxy();
  }

  public AopProxy createAopProxy() {
    if (advisedSupport.isProxyTargetClass()) {
      return new CglibAopProxy(advisedSupport);
    }
    return new JdkDynamicAopProxy(advisedSupport);
  }
}
