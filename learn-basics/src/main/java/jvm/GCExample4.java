package jvm;

/**
 * @author zhaoxiaoping
 * @Description: GCDemo
 * @Date 2021-4-2
 **/
public class GCExample4 {

  /**
   * 初始化堆大小: 20M
   * 新生代大小: 10M
   * Eden:Survivor = 8:1:1 (Eden: 8M, 每个 Survivor: 1M)
   * 大对象阈值: 3M
   * 对象年龄阈值: 15
   **/
  public static void main(String[] args) {
    // 1. Eden 区放入一个 4M 的对象
    byte[] array1 = new byte[4 * 1024 * 1024];
    array1 = null;
    // 2. Eden 区放入一个 2M 的对象
    byte[] array2 = new byte[2 * 1024 * 1024];
    byte[] array3 = new byte[2 * 1024 * 1024];
    byte[] array4 = new byte[2 * 1024 * 1024];
    byte[] array5 = new byte[128 * 1024];
    byte[] array6 = new byte[2 * 1024 * 1024];

  }
}
