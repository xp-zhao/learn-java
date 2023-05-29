package seq;

/**
 * @author zhaoxiaoping
 * @date 2023-4-26
 */
public class StopException extends RuntimeException {
  public static final StopException INSTANCE = new StopException();

  @Override
  public synchronized Throwable fillInStackTrace() {
    return this;
  }
}
