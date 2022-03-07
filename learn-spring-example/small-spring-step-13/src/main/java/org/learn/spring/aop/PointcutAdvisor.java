package org.learn.spring.aop;

/**
 * @author zhaoxiaoping
 * @date 2022-2-16
 */
public interface PointcutAdvisor extends Advisor {
  /** Get the Pointcut that drives this advisor. */
  Pointcut getPointcut();
}
