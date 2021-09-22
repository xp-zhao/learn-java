package jvm;

/** @author zhaoxiaoping @Description: 模拟老年代GC @Date 2021-4-2 */
public class GCExample4 {

  /**
   * 初始化堆大小: 20M<br>
   * 新生代大小: 10M<br>
   * Eden:Survivor = 8:1:1 (Eden: 8M, 每个 Survivor: 1M)<br>
   * 大对象阈值: 3M<br>
   * 对象年龄阈值: 15<br>
   * -XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520
   * -XX:MaxHeapSize=20971520 -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
   * -XX:PretenureSizeThreshold=3145728 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails
   * -XX:+PrintGCTimeStamps -Xloggc:gc.log
   */
  public static void main(String[] args) {
    // 1. Eden 区放入一个 4M 的对象
    byte[] array1 = new byte[4 * 1024 * 1024];
    array1 = null;
    // 2. Eden 区放入一个 2M 的对象
    byte[] array2 = new byte[2 * 1024 * 1024];
    byte[] array3 = new byte[2 * 1024 * 1024];
    byte[] array4 = new byte[2 * 1024 * 1024];
    byte[] array5 = new byte[128 * 1024];
    // 3. Eden区放不下, 触发 Young GC, 新生代所有对象都存活且Survivor区放不下,
    // 会直接进去老年区, 老年区也放不下所有对象, 会触发 Full GC, 回收 array1
    byte[] array6 = new byte[2 * 1024 * 1024];
  }
}
