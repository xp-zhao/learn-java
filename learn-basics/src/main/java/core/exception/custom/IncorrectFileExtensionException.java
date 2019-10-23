package core.exception.custom;

/**
 * IncorrectFileExtensionException.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/23
 **/
public class IncorrectFileExtensionException extends RuntimeException {

  public IncorrectFileExtensionException(String message, Throwable throwable) {
    super(message, throwable);
  }
}