package java.org.learn.spring.aop;

/**
 * 类匹配接口
 *
 * @author zhaoxiaoping
 * @date 2022-2-16
 */
public interface ClassFilter {
  /**
   * Should the pointcut apply to the given interface or target class?
   *
   * @param clazz the candidate target class
   * @return whether the advice should apply to the given target class
   */
  boolean matches(Class<?> clazz);
}
