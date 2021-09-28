package jvm;

import java.util.ArrayList;
import java.util.List;

/** @author zhaoxiaoping @Description: 模拟堆内存溢出示例 @Date 2021-9-28 */
public class HeapOverflowExample {

  /**
   * 设置堆内存大小为 10M<br>
   * -Xms10m -Xmx10m
   *
   * <p>完整参数配置 
   * -Xms10m 
   * -Xmx10m 
   * -XX:+PrintGCDetails 
   * -Xloggc:gc.log 
   * -XX:+HeapDumpOnOutOfMemoryError
   * -XX:HeapDumpPath=./ 
   * -XX:+UseParNewGC 
   * -XX:+UseConcMarkSweepGC
   *
   * @param args
   */
  public static void main(String[] args) {
    long counter = 0L;
    List<Object> list = new ArrayList<Object>();
    while (true) {
      list.add(new Object());
      System.out.println("创建了 " + (++counter) + " 个对象");
    }
  }
}
