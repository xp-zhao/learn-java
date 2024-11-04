package common;

/**
 * @author zhaoxiaoping
 * @date 2024-11-4
 */
public class EsException extends RuntimeException {
  private String code;
  private String message;

  public EsException(String code, String message) {
    this.code = code;
    this.message = message;
  }
}
