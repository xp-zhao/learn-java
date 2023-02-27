package org.learn.spring.v15.bean;

import lombok.extern.slf4j.Slf4j;
import org.learn.spring.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author zhaoxiaoping
 * @date 2022-5-7
 */
@Slf4j
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {

  @Override
  public void before(Method method, Object[] args, Object target) throws Throwable {
    log.info("拦截方法：{}", method.getName());
  }
}
