package async.executor;

import async.wrapper.WorkerWrapper;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * 异步工具类
 *
 * @author zhaoxiaoping
 * @date 2023-6-16
 */
public class Async {

  /** 默认线程池 */
  private static final ThreadPoolExecutor COMMON_POOL =
      (ThreadPoolExecutor) Executors.newCachedThreadPool();
  //  自定义线程池
  //  private static final ThreadPoolExecutor COMMON_POOL_1 =
  //      new ThreadPoolExecutor(
  //          Runtime.getRuntime().availableProcessors() * 2,
  //          1024,
  //          15L,
  //          TimeUnit.SECONDS,
  //          new LinkedBlockingDeque<>(),
  //          (ThreadFactory) Thread::new);

  public static void beginWork(
      long timeout, ThreadPoolExecutor pool, WorkerWrapper... workerWrapper)
      throws ExecutionException, InterruptedException {
    if (workerWrapper == null || workerWrapper.length == 0) {
      return;
    }
    List<WorkerWrapper> workerWrappers = Arrays.stream(workerWrapper).collect(Collectors.toList());
    CompletableFuture[] futures = new CompletableFuture[workerWrappers.size()];
    for (int i = 0; i < workerWrappers.size(); i++) {
      WorkerWrapper wrapper = workerWrappers.get(i);
      futures[i] =
          CompletableFuture.runAsync(() -> wrapper.work(COMMON_POOL, timeout), COMMON_POOL);
    }
    try {
      CompletableFuture.allOf(futures).get(timeout, TimeUnit.MILLISECONDS);
    } catch (TimeoutException e) {
      Set<WorkerWrapper> set = new HashSet<>();
    }
  }

  /**
   * 同步阻塞，直到所以任务都完成，或失败
   *
   * @param timeout
   * @param workerWrapper
   * @throws ExecutionException
   * @throws InterruptedException
   */
  public static void begin(long timeout, WorkerWrapper... workerWrapper)
      throws ExecutionException, InterruptedException {
    beginWork(timeout, COMMON_POOL, workerWrapper);
  }

  /**
   * 总共多少个执行单元
   *
   * @param workerWrappers
   * @param set
   */
  private static void totalWorkers(List<WorkerWrapper> workerWrappers, Set<WorkerWrapper> set) {
    set.addAll(workerWrappers);
    for (WorkerWrapper wrapper : workerWrappers) {}
  }

  /**
   * 关闭线程池
   *
   * @param executorService
   */
  public static void shutDown() {
    COMMON_POOL.shutdown();
  }

  public static String getThreadCount() {
    return "activeCount="
        + COMMON_POOL.getActiveCount()
        + " completedCount="
        + COMMON_POOL.getCompletedTaskCount()
        + " largestCount="
        + COMMON_POOL.getLargestPoolSize();
  }
}
