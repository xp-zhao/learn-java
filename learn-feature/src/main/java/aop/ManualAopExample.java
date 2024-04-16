package aop;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * 手动创建 aop 代理对象示例
 *
 * @author zhaoxiaoping
 * @date 2024-4-16
 */
@Slf4j
public class ManualAopExample {
  public static void main(String[] args) {
    // 创建目标对象
    MyService targetService = new MyServiceImpl();
    targetService.doSomething();
    // 创建 advice 对象
    MethodInterceptor advice = new LogAdvice();
    // 创建 advisor 对象
    Advisor advisor = new DefaultPointcutAdvisor(advice);
    // 创建代理对象
    ProxyFactory proxyFactory = new ProxyFactory();
    proxyFactory.setTarget(targetService);
    proxyFactory.addAdvisor(advisor);
    MyService proxyService = (MyService) proxyFactory.getProxy();

    // 调用代理对象的方法
    proxyService.doSomething();
  }
}

interface MyService {
  void doSomething();
}

@Slf4j
class MyServiceImpl implements MyService {

  @Override
  public void doSomething() {
    log.info("doing something...");
  }
}

@Slf4j
class LogAdvice implements MethodInterceptor {

  @Nullable
  @Override
  public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
    log.info("before method invocation: {}", invocation.getMethod().getName());
    Object result = invocation.proceed();
    log.info("after method invocation: {}", invocation.getMethod().getName());
    return result;
  }
}
