package poll;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 动态调度器
 *
 * @author zhaoxiaoping
 * @date 2025-07-22
 */
public class DynamicScheduler {
  /** 平台配置类 */
  static class Platform {
    final String name;

    /** 执行间隔(毫秒) */
    final long interval;

    /** 下次允许执行的时间 */
    long nextAllowedTime;

    /** 上次请求时间 */
    long lastRequestTime;

    public Platform(String name, long interval) {
      this.name = name;
      this.interval = interval * 1000;
      // 初始化时，允许立即执行，即当前时间
      this.nextAllowedTime = System.currentTimeMillis();
    }
  }

  private final PriorityQueue<Platform> queue =
      new PriorityQueue<>(Comparator.comparingLong(p -> p.nextAllowedTime));
  private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

  public DynamicScheduler() {
    // 添加平台配置
    addPlatform("Platform1", 1);
    addPlatform("Platform2", 3);
    addPlatform("Platform3", 5);
  }

  public void addPlatform(String name, long intervalSeconds) {
    queue.add(new Platform(name, intervalSeconds));
  }

  public void start() {
    // 启动调度器（每秒检查一次）
    scheduler.scheduleAtFixedRate(this::checkPlatforms, 0, 1, TimeUnit.SECONDS);
  }

  public void stop() {
    scheduler.shutdown();
  }

  private void checkPlatforms() {}

  private void executePlatformRequest(PlatformLaneScheduler.Platform platform, long now) {
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
  }

  public static void main(String[] args) throws InterruptedException {
    DynamicScheduler scheduler = new DynamicScheduler();
    scheduler.start();
    // 运行 60 秒
    TimeUnit.SECONDS.sleep(60);
    scheduler.stop();
  }
}
