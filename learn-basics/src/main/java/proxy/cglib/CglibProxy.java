package proxy.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author zhaoxiaoping
 * @date 2022-2-17
 */
public class CglibProxy implements MethodInterceptor {

  public Object newInstance(Object object) {
    return Enhancer.create(object.getClass(), this);
  }

  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {
    System.out.println("我被CglibProxy代理了");
    return methodProxy.invokeSuper(o, objects);
  }
}
