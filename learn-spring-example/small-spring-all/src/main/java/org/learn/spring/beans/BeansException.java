package org.learn.spring.beans;

/**
 * Bean 异常对象
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public class BeansException extends RuntimeException {
  public BeansException(String msg) {
    super(msg);
  }

  public BeansException(String msg, Throwable throwable) {
    super(msg, throwable);
  }
}
