package org.tiny.beans;

/** @author zhaoxiaoping @Description: 自定义 bean 异常 @Date 2021-8-19 */
public class BeansException extends RuntimeException {

  private static final long serialVersionUID = -7775896250755031921L;

  public BeansException(String message) {
    super(message);
  }

  public BeansException(String message, Throwable cause) {
    super(message, cause);
  }
}
