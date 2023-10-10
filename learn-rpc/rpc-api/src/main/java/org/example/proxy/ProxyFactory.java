package org.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import org.example.common.Invocation;
import org.example.common.URL;
import org.example.loadbalance.LoadBalance;
import org.example.protocol.HttpClient;
import org.example.register.MapRemoteRegister;

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

                String mock = System.getProperty("mock");
                if (mock != null && mock.startsWith("return:")) {
                  return mock.replace("return:", "");
                }

                Invocation invocation =
                    new Invocation(
                        interfaceClass.getName(),
                        method.getName(),
                        method.getParameterTypes(),
                        args);
                HttpClient httpClient = new HttpClient();

                // 服务发现，从注册中心获取对应接口的请求地址
                List<URL> urls = MapRemoteRegister.get(interfaceClass.getName());

                // 服务调用
                String result = null;

                // 重试
                int maxRetryCount = 3;
                List<URL> invokedUrls = new ArrayList<>();
                while (maxRetryCount > 0) {
                  // 负载均衡
                  urls.removeAll(invokedUrls);
                  URL url = LoadBalance.random(urls);
                  invokedUrls.add(url);
                  try {
                    result = httpClient.send(url.getHostname(), url.getPort(), invocation);
                    break;
                  } catch (Exception e) {
                    if (maxRetryCount-- == 0) {
                      continue;
                    }
                    // 服务容错
                    // error-callback=com.example.HelloServiceCallback
                    return "error";
                  }
                }
                return result;
              }
            });
    return (T) proxyInstance;
  }
}
