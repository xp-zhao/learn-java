package concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author zhaoxiaoping
 * @Description: Fork/Join 使用示例(计算斐波那契数列)
 * @Date 2020/4/17
 **/
public class ForkJoinDemo {

  public static void main(String[] args) {
    // 创建分治任务线程池  
    ForkJoinPool pool = new ForkJoinPool(4);
    // 创建分治任务
    Fibonacci fb = new Fibonacci(5);
    // 启动分治任务
    Integer result = pool.invoke(fb);
    System.out.println(result);
  }

  /**
   * 递归任务
   */
  static class Fibonacci extends RecursiveTask<Integer> {

    final int n;

    Fibonacci(int n) {
      this.n = n;
    }

    @Override
    protected Integer compute() {
      if (n <= 1) {
        return n;
      }
      Fibonacci f1 = new Fibonacci(n - 1);
      // 创建子任务
      f1.fork();
      Fibonacci f2 = new Fibonacci(n - 2);
//      invokeAll(f1,f2);
      // 等待子任务结果，并合并结果
//      return f2.join() + f1.join();
      return f2.compute() + f1.join();
    }
  }

}
