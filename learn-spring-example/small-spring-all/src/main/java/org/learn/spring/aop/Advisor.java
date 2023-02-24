package org.learn.spring.aop;

import org.aopalliance.aop.Advice;

/**
 * Advisor 接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-23
 */
public interface Advisor {
  Advice getAdvice();
}
