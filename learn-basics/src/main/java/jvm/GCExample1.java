package jvm;

/** @author zhaoxiaoping @Description: 模拟新生代GC @Date 2021-4-2 */
public class GCExample1 {

  /**
   * 初始化堆大小: 10M<br>
   * 新生代大小: 5M<br>
   * Eden:Survivor = 8:1:1 (Eden: 4M, 每个 Survivor: 0.5M)<br>
   * 大对象阈值: 10M<br>
   * -XX:NewSize=5242880 -XX:MaxNewSize=5242880 -XX:InitialHeapSize=10485760
   * -XX:MaxHeapSize=10485760 -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=10485760
   * -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
   * -Xloggc:gc.log
   */
  public static void main(String[] args) {
    // 1. Eden 区放入一个 1M 的对象
    byte[] array1 = new byte[1024 * 1024];
    // 2. Eden 区放入一个 1M 的对象 (前一个对象变为垃圾对象)
    array1 = new byte[1024 * 1024];
    // 3. Eden 区放入一个 1M 的对象 (前一个对象变为垃圾对象)
    array1 = new byte[1024 * 1024];
    // 4. 前三个对象变为垃圾对象
    array1 = null;
    // 5. 分配一个 2M 的对象, 尝试放入 Eden 区 (此时 Eden 区已经有 3M 的对象, 所以会触发 Young GC)
    byte[] array2 = new byte[2 * 1024 * 1024];
  }
}
