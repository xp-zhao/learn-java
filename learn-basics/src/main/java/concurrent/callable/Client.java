package concurrent.callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Client.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/14
 **/
public class Client {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Future future = executorService.submit(new EventLoggingTask());
    executorService.shutdown();
  }
}