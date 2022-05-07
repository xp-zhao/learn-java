package org.learn.spring.aop.framework;

import org.learn.spring.aop.AdvisedSupport;

/**
 * 代理工厂
 *
 * @author zhaoxiaoping
 * @date 2022-2-16
 */
public class ProxyFactory {
  private AdvisedSupport advisedSupport;

  public ProxyFactory(AdvisedSupport advisedSupport) {
    this.advisedSupport = advisedSupport;
  }

  public Object getProxy() {
    return createAopProxy().getProxy();
  }

  private AopProxy createAopProxy() {
    if (advisedSupport.isProxyTargetClass()) {
      return new Cglib2AopProxy(advisedSupport);
    }
    return new JdkDynamicAopProxy(advisedSupport);
  }
}
