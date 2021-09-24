package jvm;

import java.util.concurrent.TimeUnit;

/** @author zhaoxiaoping @Description: 模拟频繁 Full GC 的情况 @Date 2021-9-24 */
public class GCExample6 {
  /**
   *
   *
   * <h1>优化前-频繁触发 Full GC</h1>
   *
   * 初始化堆内存: 200M<br>
   * 新生代: 100M<br>
   * Eden:Survivor = 8:1:1 (Eden: 80M, 每个 Survivor: 10M)<br>
   * 大对象阈值: 20M<br>
   * 对象年龄阈值: 15<br>
   * -XX:NewSize=104857600 -XX:MaxNewSize=104857600 -XX:InitialHeapSize=209715200
   * -XX:MaxHeapSize=209715200 - XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
   * -XX:PretenureSizeThreshold=20971520 -XX:+UseParNewGC - XX:+UseConcMarkSweepGC
   * -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
   *
   * <h1>优化后-大大减少了对象进入老年代的情况</h1>
   *
   * 初始化堆内存: 300M<br>
   * 新生代: 200M<br>
   * Eden:Survivor = 2:1:1 (Eden: 100M, 每个 Survivor: 50M)<br>
   * 大对象阈值: 20M<br>
   * 对象年龄阈值: 15<br>
   * -XX:NewSize=209715200 -XX:MaxNewSize=209715200 -XX:InitialHeapSize=314572800
   * -XX:MaxHeapSize=314572800 -XX:SurvivorRatio=2 -XX:MaxTenuringThreshold=15
   * -XX:PretenureSizeThreshold=20971520 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC
   * -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
   *
   * @param args
   * @throws InterruptedException
   */
  public static void main(String[] args) throws InterruptedException {
    TimeUnit.SECONDS.sleep(30);
    while (true) {
      loadData();
    }
  }

  public static void loadData() throws InterruptedException {
    byte[] data = null;
    for (int i = 0; i < 4; i++) {
      data = new byte[10 * 1024 * 1024];
    }
    data = null;
    byte[] data1 = new byte[10 * 1024 * 1024];
    byte[] data2 = new byte[10 * 1024 * 1024];

    byte[] data3 = new byte[10 * 1024 * 1024];
    data3 = new byte[10 * 1024 * 1024];

    TimeUnit.SECONDS.sleep(1);
  }
}
