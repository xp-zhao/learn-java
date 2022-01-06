package org.learn.spring.beans.factory.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import org.learn.spring.beans.factory.FactoryBean;

/**
 * @author zhaoxiaoping
 * @date 2022-1-6
 */
public class ProxyBeanFactory implements FactoryBean<IUserDao> {

  @Override
  public IUserDao getObject() throws Exception {
    InvocationHandler handler =
        (proxy, method, args) -> {
          Map<String, String> hashMap = new HashMap<>();
          hashMap.put("10001", "xxx-1");
          hashMap.put("10002", "xxx-2");
          hashMap.put("10003", "xxx-3");
          return "你被代理了 " + method.getName() + "：" + hashMap.get(args[0].toString());
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
