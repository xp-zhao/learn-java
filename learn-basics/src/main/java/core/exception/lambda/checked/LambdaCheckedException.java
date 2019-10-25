package core.exception.lambda.checked;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * LambdaCheckedException.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/25
 **/
public class LambdaCheckedException {

  public static void main(String[] args) {
    List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
    // first
//    integers.forEach(i -> {
//      try {
//        writeToFile(i);
//      } catch (IOException e) {
//        throw new RuntimeException(e);
//      }
//    });
    // second
    integers.forEach(throwingConsumerWrapper(i -> writeToFile(i), IOException.class));
  }

  public static void writeToFile(Integer integer) throws IOException {

  }

  static <T, E extends Exception> Consumer<T> throwingConsumerWrapper(
      ThrowingConsumer<T, E> throwingConsumer, Class<E> exceptionClass) {
    return i -> {
      try {
        throwingConsumer.accept(i);
      } catch (Exception e) {
        try {
          E exCast = exceptionClass.cast(e);
          System.err.println("Exception occured : " + exCast.getMessage());
        } catch (ClassCastException ex) {
          throw new RuntimeException(e);
        }
      }
    };
  }
}