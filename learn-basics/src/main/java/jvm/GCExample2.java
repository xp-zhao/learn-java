package jvm;

/**
 * @author zhaoxiaoping
 * @Description: GCDemo
 * @Date 2021-4-2
 **/
public class GCExample2 {

  /**
   * 初始化堆大小: 20M
   * 新生代大小: 10M
   * Eden:Survivor = 8:1:1 (Eden: 8M, 每个 Survivor: 1M)
   * 大对象阈值: 10M
   * 对象年龄阈值: 15
   **/
  public static void main(String[] args) {
    // 1. Eden 区放入一个 2M 的对象
    byte[] array1 = new byte[2 * 1024 * 1024];
    // 2. Eden 区放入一个 2M 的对象 (前一个对象变为垃圾对象)
    array1 = new byte[2 * 1024 * 1024];
    // 3. Eden 区放入一个 2M 的对象 (前一个对象变为垃圾对象)
    array1 = new byte[2 * 1024 * 1024];
    // 4. 前三个对象变为垃圾对象
    array1 = null;
    // 5. 分配一个 128k 的对象
    byte[] array2 = new byte[128 * 1024];
    // 6. 分配一个 2M 的对象, 尝试放入 Eden 区 (此时 Eden 区已经有 6M+ 的对象, 所以会触发 Young GC)
    byte[] array3 = new byte[2 * 1024 * 1024];

    array3 = new byte[2 * 1024 * 1024];
    array3 = new byte[2 * 1024 * 1024];
    array3 = new byte[128 * 1024];
    array3 = null;
    byte[] array4 = new byte[2 * 1024 * 1024];

  }
}
