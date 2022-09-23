import com.example.feature.Application;
import com.example.feature.retry.SpringRetryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xp-zhao
 * @description SpringRetry测试
 * @date 2022/9/24 1:19
 */
@Slf4j
@SpringBootTest(classes = Application.class)
public class SprintRetryTest {
  @Autowired private SpringRetryService retryService;

  @Test
  public void testRetry() throws Exception {
    retryService.retryMethod();
  }
}
