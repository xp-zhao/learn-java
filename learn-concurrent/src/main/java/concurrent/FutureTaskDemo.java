package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoxiaoping
 * @Description: 烧水泡茶代码实现
 * @Date 2020/4/17
 **/
public class FutureTaskDemo {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    FutureTask<String> t2 = new FutureTask<>(new T2Task());
    FutureTask<String> t1 = new FutureTask<>(new T1Task(t2));
    
    Thread thread1 = new Thread(t1);
    thread1.start();
    Thread thread2 = new Thread(t2);
    thread2.start();

    System.out.println(t1.get());
  }

  /**
   * T1 洗水壶，烧开始，泡茶
   */
  static class T1Task implements Callable<String> {

    FutureTask<String> t2;

    T1Task(FutureTask<String> t2) {
      this.t2 = t2;
    }

    @Override
    public String call() throws Exception {
      System.out.println("T1:洗水壶...");
      TimeUnit.SECONDS.sleep(1);

      System.out.println("T1:烧开水...");
      TimeUnit.SECONDS.sleep(15);
      // 获取T2线程的茶叶  
      String tf = t2.get();
      System.out.println("T1:拿到茶叶:" + tf);

      System.out.println("T1:泡茶...");
      return "上茶:" + tf;
    }
  }

  /**
   * 洗茶壶，洗茶杯，拿茶叶
   */
  static class T2Task implements Callable<String> {

    @Override
    public String call() throws Exception {
      System.out.println("T2:洗茶壶...");
      TimeUnit.SECONDS.sleep(1);

      System.out.println("T2:洗茶杯...");
      TimeUnit.SECONDS.sleep(2);

      System.out.println("T2:拿茶叶...");
      TimeUnit.SECONDS.sleep(1);
      return "龙井";
    }
  }
}
