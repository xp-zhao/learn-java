package java.org.learn.spring.aop;

import java.lang.reflect.Method;

/**
 * 方法匹配接口
 *
 * @author zhaoxiaoping
 * @date 2022-2-16
 */
public interface MethodMatcher {
  /**
   * Perform static checking whether the given method matches. If this
   *
   * @return whether or not this method matches statically
   */
  boolean matches(Method method, Class<?> targetClass);
}
