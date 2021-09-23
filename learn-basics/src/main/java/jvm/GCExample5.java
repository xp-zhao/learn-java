package jvm;

import java.util.concurrent.TimeUnit;

/** @Author: xp-zhao @Description: 模拟频繁 Young GC 的情况 @DateTime: 2021/6/4 11:31 下午 */
public class GCExample5 {

  /**
   * 初始化堆内存: 200M<br>
   * 新生代: 100M<br>
   * Eden:Survivor = 8:1:1 (Eden: 80M, 每个 Survivor: 10M)<br>
   * 大对象阈值: 3M<br>
   * 对象年龄阈值: 15<br>
   * -XX:NewSize=104857600 -XX:MaxNewSize=104857600 -XX:InitialHeapSize=209715200
   * -XX:MaxHeapSize=209715200 - XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
   * -XX:PretenureSizeThreshold=3145728 -XX:+UseParNewGC - XX:+UseConcMarkSweepGC
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
    for (int i = 0; i < 50; i++) {
      data = new byte[100 * 1024];
    }
    data = null;
    TimeUnit.SECONDS.sleep(1);
  }
}
