package proxy.jdk.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import proxy.jdk.util.ClassLoaderUtils;

/**
 * 代理类获取服务
 *
 * @author zhaoxiaoping
 * @date 2022-2-17
 */
public class JDKProxy {
  public static <T> T getProxy(Class<T> interfaceClass) {
    InvocationHandler handler = new JDKInvocationHandler();
    ClassLoader classLoader = ClassLoaderUtils.getCurrentClassLoader();
    return (T) Proxy.newProxyInstance(classLoader, new Class[] {interfaceClass}, handler);
  }
}
