package jvm;

/** @author zhaoxiaoping @Description: 模拟对象从新生代进入老年代 @Date 2021-4-2 */
public class GCExample2 {

  /**
   * 初始化堆大小: 20M<br>
   * 新生代大小: 10M<br>
   * Eden:Survivor = 8:1:1 (Eden: 8M, 每个 Survivor: 1M)<br>
   * 大对象阈值: 10M<br>
   * 对象年龄阈值: 15<br>
   * -XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520
   * -XX:MaxHeapSize=20971520 - XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
   * -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC - XX:+UseConcMarkSweepGC
   * -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
   */
  public static void main(String[] args) {
    // 1. Eden 区放入一个 2M 的对象
    byte[] array1 = new byte[2 * 1024 * 1024];
    // 2. Eden 区放入一个 2M 的对象 (前一个对象变为垃圾对象)
    array1 = new byte[2 * 1024 * 1024];
    // 3. Eden 区放入一个 2M 的对象 (前一个对象变为垃圾对象)
    array1 = new byte[2 * 1024 * 1024];
    // 4. 前三个对象变为垃圾对象(占用 6M 空间)
    array1 = null;
    // 5. 分配一个 128k 的对象
    byte[] array2 = new byte[128 * 1024];
    // 6. 分配一个 2M 的对象, 尝试放入 Eden 区 (此时 Eden 区已经有 6M+ 的对象, 所以会触发第一次 Young GC)
    byte[] array3 = new byte[2 * 1024 * 1024];
    // 7. Eden 区放入一个 2M 的对象
    array3 = new byte[2 * 1024 * 1024];
    // 8. Eden 区放入一个 2M 的对象
    array3 = new byte[2 * 1024 * 1024];
    // 8. Eden 区放入一个 2M 的对象
    array3 = new byte[128 * 1024];
    array3 = null;
    // 9. 分配一个 2M 的对象, 尝试放入 Eden 区(放不下, 触发第二次 Young GC)
    byte[] array4 = new byte[2 * 1024 * 1024];
  }
}
