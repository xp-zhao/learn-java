package track;

import org.junit.Test;

/**
 * @author zhaoxiaoping
 * @date 2024-12-9
 */
public class WatchTrackerTest {
  @Test
  public void test() {
    WatchTracker.track(
        "测试1",
        () -> {
          Thread.sleep(1000);
          return "success";
        });
    try (WatchTracker watchTracker = WatchTracker.start("测试2")) {
      Thread.sleep(1000);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
