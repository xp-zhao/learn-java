package com.example.feature.concurrent.component;

import com.example.feature.concurrent.Processor;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @author zhaoxiaoping
 * @date 2023-3-2
 */
@Slf4j
public class ProducerAndConsumerComponent<T> {

  /** 工作线程数组 */
  private final WorkThread<T>[] workThreads;

  private AtomicInteger index;
  private static final Random random = new Random();
  /** 定时器 */
  private static ScheduledExecutorService scheduleThreadPool = new ScheduledThreadPoolExecutor(1);

  private static ExecutorService executorService = Executors.newCachedThreadPool();

  public ProducerAndConsumerComponent(
      int threadNum, int limitSize, int period, int capacity, Processor<T> processor) {
    this.workThreads = new WorkThread[threadNum];
    if (threadNum > 1) {
      this.index = new AtomicInteger();
    }
    for (int i = 0; i < threadNum; i++) {
      WorkThread<T> workThread =
          new WorkThread<>("workThread" + "_" + i, limitSize, period, capacity, processor);
      this.workThreads[i] = workThread;
      executorService.submit(workThread);
      // 每个工作线程都开启一个定时器, 检查各自的 timeout 方法
      scheduleThreadPool.scheduleAtFixedRate(
          workThread::timeout, random.nextInt(50), period, TimeUnit.MILLISECONDS);
    }
  }

  public boolean add(T item) {
    int len = this.workThreads.length;
    if (len == 1) {
      return this.workThreads[0].add(item);
    } else {
      int mod = this.index.incrementAndGet() % len;
      return this.workThreads[mod].add(item);
    }
  }

  private static class WorkThread<T> implements Runnable {

    /** 工作线程名称 */
    private final String threadName;
    /** 队列中允许存放的元素个数 */
    private final int queueSizeLimit;
    /** 任务的执行周期 */
    private int period;
    /** 任务的即时处理时间 */
    private volatile long lastFlushTime;
    /** 当前工作线程 */
    private volatile Thread currentThread;
    /** 工作线程对象内部阻塞队列 */
    private final BlockingQueue<T> queue;
    /** 回调接口 */
    private final Processor<T> processor;

    /**
     * 工作线程构造器
     *
     * @param threadName
     * @param queueSizeLimit
     * @param period
     * @param capacity
     * @param processor
     */
    public WorkThread(
        String threadName, int queueSizeLimit, int period, int capacity, Processor<T> processor) {
      this.threadName = threadName;
      this.queueSizeLimit = queueSizeLimit;
      this.period = period;
      this.lastFlushTime = System.currentTimeMillis();
      this.processor = processor;
      this.queue = new ArrayBlockingQueue(capacity);
    }

    public boolean add(T item) {
      boolean result = this.queue.offer(item);
      this.checkQueueSize();
      return result;
    }

    public void timeout() {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      if (System.currentTimeMillis() - lastFlushTime >= this.period) {
        log.info(
            "当前时间 {} 距离上次任务处理时间 {} 周期 {} 超出指定阈值 {}",
            format.format(System.currentTimeMillis()),
            format.format(lastFlushTime),
            (System.currentTimeMillis() - lastFlushTime),
            period);
        this.start();
      }
    }

    private void checkQueueSize() {
      if (this.queue.size() > this.queueSizeLimit) {
        log.info(
            "{} 队列大小 {} 超出指定阈值 {}", currentThread.getName(), this.queue.size(), queueSizeLimit);
        this.start();
      }
    }

    private void start() {
      log.info("执行 start 方法, 唤醒被阻塞的线程 {}", currentThread.getName());
      LockSupport.unpark(this.currentThread);
    }

    public void flush() {
      this.lastFlushTime = System.currentTimeMillis();
      if (queue.isEmpty()) {
        log.info("阻塞队列为空, 不需要处理");
        return;
      }
      List<T> temp = new ArrayList<>(this.queueSizeLimit);
      int size = this.queue.drainTo(temp, this.queueSizeLimit);
      if (size > 0) {
        log.info("线程 {} 被唤醒后, 开始执行任务, 从队列中腾出大小为 {} 的数据并转换为 list 对象", currentThread.getName(), size);
        try {
          this.processor.process(temp);
        } catch (Exception e) {
          log.error("process error");
        }
      }
    }

    private boolean canFlush() {
      return this.queue.size() > this.queueSizeLimit
          || (System.currentTimeMillis() - lastFlushTime) > this.period;
    }

    @Override
    public void run() {
      this.currentThread = Thread.currentThread();
      this.currentThread.setName(this.threadName);
      while (!this.currentThread.isInterrupted()) {
        while (!this.canFlush()) {
          log.info("线程 {} 被阻塞", currentThread.getName());
          LockSupport.park(this);
        }
        this.flush();
      }
    }
  }
}
