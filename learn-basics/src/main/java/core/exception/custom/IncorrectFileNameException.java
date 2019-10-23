package core.exception.custom;

/**
 * IncorrectFileNameException.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/23
 **/
public class IncorrectFileNameException extends Exception {

  public IncorrectFileNameException(String message) {
    super(message);
  }

  public IncorrectFileNameException(String message, Throwable throwable) {
    super(message, throwable);
  }
}