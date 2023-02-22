package org.learn.spring.v9.bean;

import org.learn.spring.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
public class ProxyBeanFactory implements FactoryBean<IUserDao> {
  @Override
  public IUserDao getObject() throws Exception {
    InvocationHandler handler =
        (proxy, method, args) -> {
          Map<String, String> map = new HashMap<>();
          map.put("10001", "xxx-1");
          map.put("10002", "xxx-2");
          map.put("10003", "xxx-3");
          return "你被代理了 " + method.getName() + "：" + map.get(args[0].toString());
        };
    return (IUserDao)
        Proxy.newProxyInstance(
            Thread.currentThread().getContextClassLoader(), new Class[] {IUserDao.class}, handler);
  }

  @Override
  public Class<?> getObjectType() {
    return IUserDao.class;
  }

  @Override
  public boolean isSingleton() {
    return true;
  }
}
