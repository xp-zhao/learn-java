package concurrent.example.sequence;
/**
 * 让 T1, T2, T3 三个线程顺序执行-通过 join 实现
 *
 * @author zhaoxiaoping
 * @date 2023-7-11
 */
public class SeqByJoin {
  public static void main(String[] args) {
    Thread t1 =
        new Thread(
            () -> {
              System.out.println(Thread.currentThread().getName() + " is running");
            },
            "T1");
    Thread t2 =
        new Thread(
            () -> {
              try {
                t1.join();
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
              System.out.println(Thread.currentThread().getName() + " is running");
            },
            "T2");
    Thread t3 =
        new Thread(
            () -> {
              try {
                t2.join();
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
              System.out.println(Thread.currentThread().getName() + " is running");
            },
            "T3");
    t2.start();
    t1.start();
    t3.start();
  }
}
