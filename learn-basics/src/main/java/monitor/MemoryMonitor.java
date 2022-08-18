package monitor;

import lombok.extern.slf4j.Slf4j;

/**
 * 内存监控器
 *
 * @author xp-zhao
 * @date 2022/8/18
 */
@Slf4j
public class MemoryMonitor {

  public static void logMemory() {
    log.info("Max Memory: {} Mb", Runtime.getRuntime().maxMemory() / 1048576);
    log.info("Total Memory: {} Mb", Runtime.getRuntime().totalMemory() / 1048576);
    log.info("Free Memory: {} Mb", Runtime.getRuntime().freeMemory() / 1048576);
  }

  public static void main(String[] args) {
    logMemory();
  }
}
