package retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * 重试服务
 *
 * @author zhaoxiaoping
 * @date 2023-4-10
 */
@Service
@Slf4j
public class RetryService {
  @Retryable
  void retry() {
    log.info("throw RuntimeException");
    throw new RuntimeException();
  }
}
