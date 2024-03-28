package mockito.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author zhaoxiaoping
 * @date 2024-3-28
 */
@Slf4j
public class DemoTest {

  @Test
  public void testRandomCount() {
    DemoDao demoDao = new DemoDao();
    log.info("random count: {}", demoDao.getRandomCount());
  }

  @Test
  public void testDemo() {
    DemoDao demoDao = Mockito.mock(DemoDao.class);
    Mockito.when(demoDao.getRandomCount()).thenReturn(1);
    Assert.assertEquals(1, demoDao.getRandomCount());
    DemoService demoService = new DemoService(demoDao);
    Assert.assertEquals(1, demoService.getRandomCount());
  }
}
