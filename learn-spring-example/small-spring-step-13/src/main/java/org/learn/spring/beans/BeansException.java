package org.learn.spring.beans;

/**
 * 定义 Bean 异常
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public class BeansException extends RuntimeException {
  public BeansException(String msg) {
    super(msg);
  }

  public BeansException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
