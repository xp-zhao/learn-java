package com.spring.example02.v3;

import java.util.concurrent.CompletableFuture;

/**
 * 异步调用工具类
 *
 * @author zhaoxiaoping
 * @date 2024-3-27
 */
public class AsyncInvoke {
  public static <R> CompletableFuture<R> doInvoker(CallbackTask<R> executeTask) {
    CompletableFuture<R> invoke =
        CompletableFuture.supplyAsync(
                () -> {
                  try {
                    return executeTask.execute();
                  } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                  }
                })
            .whenComplete(
                (result, throwable) -> {
                  if (throwable == null) {
                    executeTask.onSuccess(result);
                  }
                })
            .exceptionally(
                throwable -> {
                  executeTask.onFailure(throwable);
                  return null;
                });
    return invoke;
  }
}
