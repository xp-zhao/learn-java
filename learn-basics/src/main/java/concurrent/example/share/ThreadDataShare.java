package concurrent.example.share;
/**
 * 父子线程数据共享
 *
 * @author zhaoxiaoping
 * @date 2023-7-11
 */
public class ThreadDataShare {
  public static InheritableThreadLocal<Integer> sharedData = new InheritableThreadLocal<>();

  public static void main(String[] args) {
    sharedData.set(0);
    new Thread(new MyThread()).start();
    sharedData.set(sharedData.get() + 1);
    System.out.println("sharedData in main thread: " + sharedData.get());
  }

  static class MyThread implements Runnable {

    @Override
    public void run() {
      System.out.println("sharedData in child thread: " + sharedData.get());
      sharedData.set(sharedData.get() + 1);
      System.out.println("sharedData in child thread after increment: " + sharedData.get());
    }
  }
}
