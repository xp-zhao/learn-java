import cn.hutool.core.util.RandomUtil;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.google.common.base.Predicates;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author xp-zhao
 * @description GuavaRetry测试
 * @date 2022/9/24 1:27
 */
@Slf4j
public class GuavaRetryTest {
  @Test
  public void testRetry() {
    Retryer<Boolean> retryBuild =
        RetryerBuilder.<Boolean>newBuilder() // 要重试函数的返回类型
            .retryIfExceptionOfType(Exception.class)
            .retryIfResult(Predicates.equalTo(false))
            .withWaitStrategy(WaitStrategies.fixedWait(5, TimeUnit.SECONDS))
            .withStopStrategy(StopStrategies.stopAfterAttempt(3))
            .build();
    try {
      retryBuild.call(() -> func());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private boolean func() {
    boolean result = RandomUtil.randomBoolean();
    log.info("[func][{}]", result);
    return result;
  }
}
