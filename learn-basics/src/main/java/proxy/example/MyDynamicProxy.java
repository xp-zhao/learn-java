package proxy.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/7/20
 */
public class MyDynamicProxy implements InvocationHandler {

  private Object obj;

  public MyDynamicProxy(Object obj){
    this.obj = obj;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println(proxy.getClass());
    System.out.println(method.getName());
    System.out.println(Arrays.toString(args));

    return method.invoke(obj, args);
  }
}
