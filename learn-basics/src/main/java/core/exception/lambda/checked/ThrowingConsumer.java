package core.exception.lambda.checked;

/**
 * @author: zhaoxiaoping
 * @date: 2019/10/25
 **/
@FunctionalInterface
public interface ThrowingConsumer<T, E extends Exception> {

  void accept(T t) throws E;
}
