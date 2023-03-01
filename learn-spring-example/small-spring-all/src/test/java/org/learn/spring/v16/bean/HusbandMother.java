package org.learn.spring.v16.bean;

import org.learn.spring.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-28
 */
public class HusbandMother implements FactoryBean<IMother> {
  @Override
  public IMother getObject() throws Exception {
    return (IMother)
        Proxy.newProxyInstance(
            Thread.currentThread().getContextClassLoader(),
            new Class[] {IMother.class},
            (proxy, method, args) -> method.getName() + ": 被代理了！");
  }

  @Override
  public Class<?> getObjectType() {
    return IMother.class;
  }

  @Override
  public boolean isSingleton() {
    return true;
  }
}
