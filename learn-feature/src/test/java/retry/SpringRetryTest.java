package retry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * 测试类
 *
 * @author zhaoxiaoping
 * @date 2023-4-10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RetryConfig.class, loader = AnnotationConfigContextLoader.class)
public class SpringRetryTest {

  @Autowired private RetryService retryService;
  @Autowired private RetryTemplate retryTemplate;

  @Test(expected = RuntimeException.class)
  public void testCallWithException() {
    retryService.retry();
  }

  @Test(expected = RuntimeException.class)
  public void testTemplate() {
    retryTemplate.execute(
        __ -> {
          retryService.retry();
          return null;
        });
  }
}
