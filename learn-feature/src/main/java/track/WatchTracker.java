package track;

import cn.hutool.core.lang.Console;

/**
 * 代码执行监控工具
 *
 * @author zhaoxiaoping
 * @date 2024-12-9
 */
public class WatchTracker implements AutoCloseable {
  /** 任务名称 */
  private final String taskName;

  /** 开始时间 */
  private final long startTime;

  private WatchTracker(String taskName) {
    this.taskName = taskName;
    this.startTime = System.nanoTime();
    Console.log("开始执行任务：{}", taskName);
  }

  public static WatchTracker start(String taskName) {
    return new WatchTracker(taskName);
  }

  public static <T> T track(String taskName, ThrowableSupplier<T> supplier) {
    try {
      return trackThrows(taskName, supplier);
    } catch (Exception e) {
      throw new RuntimeException("执行失败： " + taskName, e);
    }
  }

  public static <T> T trackThrows(String taskName, ThrowableSupplier<T> supplier) throws Exception {
    try (WatchTracker watchTracker = new WatchTracker(taskName)) {
      return supplier.get();
    }
  }

  /**
   * 跟踪无返回值的代码块执行时间，异常会被包装为RuntimeException。
   *
   * @param taskName 操作名称
   * @param execution 要执行的代码块
   * @throws RuntimeException 如果执行过程中发生异常
   */
  public static void track(String taskName, ThrowableRunnable execution) {
    try {
      trackThrows(taskName, execution);
    } catch (Exception e) {
      throw new RuntimeException("执行失败: " + taskName, e);
    }
  }

  /**
   * 跟踪无返回值的代码块执行时间，允许抛出异常。
   *
   * @param taskName 操作名称
   * @param execution 要执行的代码块
   * @throws Exception 如果执行过程中发生异常
   */
  public static void trackThrows(String taskName, ThrowableRunnable execution) throws Exception {
    try (WatchTracker watchTracker = new WatchTracker(taskName)) {
      execution.run();
    }
  }

  @Override
  public void close() throws Exception {
    long endTime = System.nanoTime();
    long executionTime = (endTime - this.startTime) / 1_000_000;
    Console.log("任务：{} 执行完成，耗时：{}ms", this.taskName, executionTime);
  }

  /**
   * 可抛出异常的Supplier函数式接口。
   *
   * @param <T> 返回值类型
   */
  @FunctionalInterface
  public interface ThrowableSupplier<T> {
    /**
     * 获取结果。
     *
     * @return 执行结果
     * @throws Exception 如果执行过程中发生错误
     */
    T get() throws Exception;
  }

  /** 可抛出异常的Runnable函数式接口。 */
  @FunctionalInterface
  public interface ThrowableRunnable {
    /**
     * 执行操作。
     *
     * @throws Exception 如果执行过程中发生错误
     */
    void run() throws Exception;
  }
}
