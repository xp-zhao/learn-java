package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @date 2024-4-18
 */
@Slf4j
public class Example {
  public static void main(String[] args) {
    IService service = new ServiceImpl();
    // 直接访问
    service.sayHi();
    // 创建代理对象进行访问
    IService proxyService =
        (IService)
            Proxy.newProxyInstance(
                ServiceImpl.class.getClassLoader(),
                new Class[] {IService.class},
                new MyInvocationHandler(service));
    proxyService.sayHi();
  }
}

interface IService {
  void sayHi();
}

@Slf4j
class ServiceImpl implements IService {

  @Override
  public void sayHi() {
    log.info("hi dynamic proxy");
  }
}

@Slf4j
class MyInvocationHandler implements InvocationHandler {
  private Object target;

  public MyInvocationHandler(Object target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    log.info("before method call");
    Object result = method.invoke(target, args);
    log.info("after method call");
    return result;
  }
}
