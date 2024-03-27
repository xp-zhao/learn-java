package com.spring.example02.v3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author zhaoxiaoping
 * @date 2024-3-27
 */
@Slf4j
public class ExampleTest {
  @Test
  public void testAsyncInvoke() throws ExecutionException, InterruptedException {
    CompletableFuture<Integer> result =
        AsyncInvoke.doInvoker(
            new CallbackTask<Integer>() {
              @Override
              public Integer execute() {
                return 1 + 1;
              }

              @Override
              public void onSuccess(Integer integer) {
                log.info("on success result: {}", integer);
              }

              @Override
              public void onFailure(Throwable t) {
                log.error("error {}", t.getMessage());
              }
            });
    log.info("result: {}", result.get());
  }
}
