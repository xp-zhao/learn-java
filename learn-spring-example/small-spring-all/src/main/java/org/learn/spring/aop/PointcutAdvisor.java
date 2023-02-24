package org.learn.spring.aop;

/**
 * PointcutAdvisor 接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-23
 */
public interface PointcutAdvisor extends Advisor {
  Pointcut getPointcut();
}
