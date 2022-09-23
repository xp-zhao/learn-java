package com.example.feature.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author xp-zhao
 * @description 重试任务
 * @date 2022/9/24 1:12
 */
@Service
@Slf4j
public class SpringRetryService {
  @Retryable(maxAttempts = 5, backoff = @Backoff(delay = 3000))
  public void retryMethod() throws Exception {
    log.info("retryMethod is called");
    throw new IllegalAccessException();
  }
}
