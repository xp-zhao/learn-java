package org.example.aop;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 切面
 *
 * @author zhaoxiaoping
 * @date 2023-9-7
 */
@Slf4j
@Component
@Scope
@Aspect
@Order(1) // order越小越是最先执行，但更重要的是最先执行的最后结束
public class LockAspect {
  private static final Lock lock = new ReentrantLock(true);

  @Pointcut("@annotation(org.example.aop.ServiceLock)")
  public void lockAspect() {}

  @Around("lockAspect()")
  public Object around(ProceedingJoinPoint joinPoint) {
    lock.lock();
    Object obj = null;
    try {
      obj = joinPoint.proceed();
    } catch (Throwable e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
    return obj;
  }
}
