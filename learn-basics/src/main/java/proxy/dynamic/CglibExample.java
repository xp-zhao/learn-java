package proxy.dynamic;

import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author zhaoxiaoping
 * @date 2024-4-18
 */
@Slf4j
public class CglibExample {
  public static void main(String[] args) {
    // 直接访问
    MyService service = new MyService();
    service.sayHi();
    // 代理类访问
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(MyService.class);
    enhancer.setCallback(new MyMethodInterceptor());
    MyService proxyService = (MyService) enhancer.create();
    proxyService.sayHi();
  }
}

@Slf4j
class MyService {

  public void sayHi() {
    log.info("hi cglib dynamic proxy");
  }
}

@Slf4j
class MyMethodInterceptor implements MethodInterceptor {

  @Override
  public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
      throws Throwable {
    log.info("before method call");
    Object result = proxy.invokeSuper(obj, args);
    log.info("after method call");
    return result;
  }
}
