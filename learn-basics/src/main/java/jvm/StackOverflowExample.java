package jvm;

/** @author zhaoxiaoping @Description: 模拟栈内存溢出示例 @Date 2021-9-28 */
public class StackOverflowExample {
  public static long counter = 0L;

  /**
   * 设置 JVM 栈内存大小为 1m<br>
   * -XX:ThreadStackSize=1m
   *
   * @param args
   */
  public static void main(String[] args) {
    work();
  }

  public static void work() {
    System.out.println("第 " + (++counter) + " 次调用");
    work();
  }
}
