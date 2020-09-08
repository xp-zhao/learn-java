package concurrent;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-3
 **/
public class CalcTest {

  private long count = 0;

  private synchronized void add10K() {
    int idx = 0;
    while (idx++ < 1000000) {
      count += 1;
    }
  }

  public static long calc() throws InterruptedException {
    final CalcTest test = new CalcTest();
    // 创建两个线程，执行add()操作
    Thread th1 = new Thread(() -> {
      test.add10K();
    });
    Thread th2 = new Thread(() -> {
      test.add10K();
    });
    // 启动两个线程
    th1.start();
    th2.start();
    // 等待两个线程执行结束
    th1.join();
    th2.join();
    return test.count;
  }

  public static void main(String[] args) throws InterruptedException {
    System.out.println(calc());
  }
}
