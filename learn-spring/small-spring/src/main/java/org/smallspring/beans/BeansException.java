package org.smallspring.beans;

/**
 * @author zhaoxiaoping
 * @Description: 自定义异常
 * @Date 2021-7-9
 **/
public class BeansException extends RuntimeException {

  private static final long serialVersionUID = -3553141380323670990L;

  public BeansException(String msg) {
    super(msg);
  }

  public BeansException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
