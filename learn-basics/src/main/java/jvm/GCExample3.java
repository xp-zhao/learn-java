package jvm;

/** @author zhaoxiaoping @Description: 模拟Survivor区放不下存活对象而直接进入老年代的情况 @Date 2021-4-2 */
public class GCExample3 {

  /**
   * 初始化堆大小: 20M<br>
   * 新生代大小: 10M<br>
   * Eden:Survivor = 8:1:1 (Eden: 8M, 每个 Survivor: 1M)<br>
   * 大对象阈值: 10M<br>
   * 对象年龄阈值: 15<br>
   */
  public static void main(String[] args) {
    // 1. Eden 区放入一个 2M 的对象
    byte[] array1 = new byte[2 * 1024 * 1024];
    // 2. Eden 区放入一个 2M 的对象 (前一个对象变为垃圾对象)
    array1 = new byte[2 * 1024 * 1024];
    // 3. Eden 区放入一个 2M 的对象 (前一个对象变为垃圾对象)
    array1 = new byte[2 * 1024 * 1024];
    // 4. 分配一个 128k 的对象
    byte[] array2 = new byte[128 * 1024];
    array2 = null;
    // 5. 触发 Young GC, array1 引用的 2M 对象不能放入 Survivor 区, 直接进入了老年代
    byte[] array3 = new byte[2 * 1024 * 1024];
  }
}
