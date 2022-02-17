package proxy.jdk.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhaoxiaoping
 * @date 2022-2-17
 */
public class JDKInvocationHandler implements InvocationHandler {

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println(method.getName());
    return "我被 JDKProxy 代理了";
  }
}
