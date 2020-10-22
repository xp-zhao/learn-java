package concurrent.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author zhaoxiaoping
 * @Description: 自定义线程池。简化的线程池，用来理解线程池工作原理
 * @Date 2020-10-22
 **/
public class MyThreadPool {

  /**
   * 利用阻塞队列实现生产者-消费者模式
   */
  BlockingQueue<Runnable> workQueue;

  /**
   * 保存内部工作线程
   */
  List<WorkThread> threads = new ArrayList<>();

  MyThreadPool(int poolSize, BlockingQueue<Runnable> workQueue) {
    this.workQueue = workQueue;
    // 创建工作线程
    for (int i = 0; i < poolSize; i++) {
      WorkThread work = new WorkThread();
      work.start();
      threads.add(work);
    }
  }

  void execute(Runnable runnable) {
    try {
      workQueue.put(runnable);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(2);
    MyThreadPool pool = new MyThreadPool(10, workQueue);
    // 提交任务
    pool.execute(() -> System.out.println("hello thread pool"));
  }
  
  class WorkThread extends Thread {

    @Override
    public void run() {
      // 循环获取任务并执行
      while (true) {
        try {
          Runnable task = workQueue.take();
          task.run();
        } catch (InterruptedException e) {
          e.printStackTrace();
          break;
        }
      }
    }
  }
}
