package async.executor;

import async.wrapper.WorkerWrapper;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * 异步工具类，客户端
 *
 * @author zhaoxiaoping
 * @date 2023-6-16
 */
public class Async {

  /** 默认不定长线程池 */
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
  /** 使用 static 修饰，表示同一组任务，只能使用一个自定义线程池 */
  private static ExecutorService executorService;
  /**
   * 执行器开始工作
   *
   * @param timeout 整组任务的超时时间
   * @param pool 自定义线程池
   * @param workerWrapper 开始的任务节点（可以是多个）
   * @throws ExecutionException
   * @throws InterruptedException
   */
  public static boolean beginWork(
      long timeout, ExecutorService executorService, WorkerWrapper... workerWrapper)
      throws ExecutionException, InterruptedException {
    if (workerWrapper == null || workerWrapper.length == 0) {
      return false;
    }
    List<WorkerWrapper> workerWrappers = Arrays.stream(workerWrapper).collect(Collectors.toList());
    return beginWork(timeout, executorService, workerWrappers);
  }

  public static boolean beginWork(
      long timeout, ExecutorService executorService, List<WorkerWrapper> workerWrappers)
      throws ExecutionException, InterruptedException {
    if (workerWrappers == null || workerWrappers.size() == 0) {
      return false;
    }
    // 保存线程池变量
    Async.executorService = executorService;
    // 定义一个map，存放所有的wrapper，key为wrapper的唯一id，value是该wrapper，可以从value中获取wrapper的result
    Map<String, WorkerWrapper> forParamUseWrappers = new ConcurrentHashMap<>();
    CompletableFuture[] futures = new CompletableFuture[workerWrappers.size()];
    // 1. 开始工作，使用 CompletableFuture 异步提交任务，调用 wrapper.work()
    for (int i = 0; i < workerWrappers.size(); i++) {
      WorkerWrapper wrapper = workerWrappers.get(i);
      futures[i] =
          CompletableFuture.runAsync(
              () -> wrapper.work(executorService, timeout, forParamUseWrappers), executorService);
    }
    // 2. 阻塞获取结果
    try {
      CompletableFuture.allOf(futures).get(timeout, TimeUnit.MILLISECONDS);
      return true;
    } catch (TimeoutException e) {
      // 3. 超时异常处理
      Set<WorkerWrapper> set = new HashSet<>();
      // 递归获取所有任务
      totalWorkers(workerWrappers, set);
      // 循环停止所有尚未执行、正在执行的任务。将state状态设置为ERROR，返回改任务设置的默认值。
      for (WorkerWrapper wrapper : set) {
        wrapper.stopNow();
      }
      return false;
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
  public static boolean begin(long timeout, WorkerWrapper... workerWrapper)
      throws ExecutionException, InterruptedException {
    return beginWork(timeout, COMMON_POOL, workerWrapper);
  }

  /**
   * 总共多少个执行单元
   *
   * @param workerWrappers
   * @param set
   */
  private static void totalWorkers(List<WorkerWrapper> workerWrappers, Set<WorkerWrapper> set) {
    set.addAll(workerWrappers);
    for (WorkerWrapper wrapper : workerWrappers) {
      List nextWrappers = wrapper.getNextWrappers();
      if (nextWrappers == null) {
        continue;
      }
      totalWorkers(nextWrappers, set);
    }
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
