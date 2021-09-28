package jvm;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/** @author zhaoxiaoping @Description: 元空间内存溢出示例 @Date 2021-9-28 */
public class MetaspaceOverflowExample {

  /**
   * 设置元空间大小为 10M<br>
   * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
   *
   * 完整参数配置
   * -XX:+UseParNewGC 
   * -XX:+UseConcMarkSweepGC 
   * -XX:MetaspaceSize=10m 
   * -XX:MaxMetaspaceSize=10m
   * -XX:+PrintGCDetails 
   * -Xloggc:gc.log 
   * -XX:+HeapDumpOnOutOfMemoryError 
   * -XX:HeapDumpPath=./
   *
   * @param args
   */
  public static void main(String[] args) {
    long counter = 0;
    while (true) {
      System.out.println(++counter);
      Enhancer enhancer = new Enhancer();
      enhancer.setUseCache(false);
      enhancer.setSuperclass(Car.class);
      enhancer.setCallback(
          new MethodInterceptor() {
            @Override
            public Object intercept(
                Object o, Method method, Object[] objects, MethodProxy methodProxy)
                throws Throwable {
              if (method.getName().equals("run")) {
                System.out.println("汽车检测");
                return methodProxy.invokeSuper(o, objects);
              } else {
                return methodProxy.invokeSuper(o, objects);
              }
            }
          });
      Car car = (Car) enhancer.create();
      car.run();
    }
  }

  static class Car {
    public void run() {
      System.out.println("汽车启动");
    }
  }
}
