package proxy.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/7/20
 */
public class Example {
  public static void main(String[] args) {
    IService s1 = new MyService();
    s1.queryName();
    s1.queryAge();
    System.out.println("=============");
    IService s2 = new MyProxy(new MyService());
    s2.queryName();
    s2.queryAge();
    System.out.println("=============");
    ClassLoader classLoader = IService.class.getClassLoader();
    Class<?>[] interfaces = new Class[]{IService.class};
    InvocationHandler handler = new MyDynamicProxy(new MyService());
    IService s3 = (IService) Proxy.newProxyInstance(classLoader, interfaces, handler);
    s3.queryName();
    s3.queryAge();
  }
}
