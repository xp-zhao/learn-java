package org.learn.spring.v16.bean;

import lombok.extern.slf4j.Slf4j;
import org.learn.spring.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-28
 */
@Slf4j
public class SpouseAdvice implements MethodBeforeAdvice {
  @Override
  public void before(Method method, Object[] args, Object target) throws Throwable {
    log.info("切面: {}", method);
  }
}
