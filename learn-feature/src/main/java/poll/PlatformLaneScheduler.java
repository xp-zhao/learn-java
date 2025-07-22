package poll;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 多车道调度器
 *
 * @author zhaoxiaoping
 * @date 2025-07-22
 */
public class PlatformLaneScheduler {
  /** 平台配置类 */
  static class Platform {
    final String name;

    /** 执行间隔(毫秒) */
    final long interval;

    /** 下次允许执行的时间 */
    long nextAllowedTime;

    public Platform(String name, long interval) {
      this.name = name;
      this.interval = interval * 1000;
      // 初始化时，允许立即执行，即当前时间
      this.nextAllowedTime = System.currentTimeMillis();
    }
  }

  /** 平台集合 */
  private final Map<String, Platform> platforms = new HashMap<>();

  /** 上次执行时间 */
  private long lastExecutionTime = 0;

  private final ScheduledExecutorService scheduler;

  public PlatformLaneScheduler() {
    // 初始化调度器
    scheduler = Executors.newSingleThreadScheduledExecutor();
    // 添加平台配置
    addPlatform("Platform1", 1);
    addPlatform("Platform2", 3);
    addPlatform("Platform3", 5);
  }

  public void addPlatform(String name, long intervalSeconds) {
    platforms.put(name, new Platform(name, intervalSeconds));
  }

  public void start() {
    scheduler.scheduleAtFixedRate(this::checkPlatforms, 0, 100, TimeUnit.MILLISECONDS);
  }

  public void stop() {
    scheduler.shutdown();
  }

  private void checkPlatforms() {
    long now = System.currentTimeMillis();
    if (now - lastExecutionTime < 1000) {
      // 全局限流, 1秒内最多执行一次
      return;
    }
    // 遍历平台, 找到符合条件的平台
    Platform earliestPlatform = null;
    long minNextTime = Long.MAX_VALUE;
    for (Platform platform : platforms.values()) {
      if (platform.nextAllowedTime <= now && platform.nextAllowedTime < minNextTime) {
        earliestPlatform = platform;
        minNextTime = platform.nextAllowedTime;
      }
    }
    if (earliestPlatform != null) {
      // 执行平台请求
      executePlatformRequest(earliestPlatform, now);
    }
  }

  private void executePlatformRequest(Platform platform, long now) {
    // 执行请求
    System.out.printf(
        "[%tT.%tL] %s平台执行 | 设定间隔: %ds | 实际间隔: %.3fs%n",
        now,
        now,
        platform.name,
        platform.interval / 1000,
        (now - platform.nextAllowedTime + platform.interval) / 1000.0);
    // 更新平台状态
    platform.nextAllowedTime = now + platform.interval;
    // 更新全局状态
    lastExecutionTime = now;
  }

  public static void main(String[] args) throws InterruptedException {
    PlatformLaneScheduler scheduler = new PlatformLaneScheduler();
    scheduler.start();
    // 运行 60 秒
    TimeUnit.SECONDS.sleep(60);
    scheduler.stop();
  }
}
