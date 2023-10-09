package org.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.example.common.Invocation;
import org.example.protocol.HttpClient;

/**
 * @author xp-zhao
 * @description
 * @date 2023/10/9 23:29
 */
public class ProxyFactory {
  public static <T> T getProxy(Class interfaceClass) {
    // 可以读取用户配置
    Object proxyInstance =
        Proxy.newProxyInstance(
            interfaceClass.getClassLoader(),
            new Class[] {interfaceClass},
            new InvocationHandler() {
              @Override
              public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Invocation invocation =
                    new Invocation(
                        interfaceClass.getName(),
                        method.getName(),
                        method.getParameterTypes(),
                        args);
                HttpClient httpClient = new HttpClient();
                String result = httpClient.send("localhost", 8080, invocation);
                return result;
              }
            });
    return (T) proxyInstance;
  }
}
