package jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/** @author zhaoxiaoping @Description: 内存快照文件示例 @Date 2021-9-26 */
public class GCExample7 {

  /**
   * 使用jmap命名dump堆内存快照: jmap -dump:live,format=b,file=dump.hprof PID<br>
   * 使用 MAT 查看分析内存快照
   *
   * @param args
   * @throws InterruptedException
   */
  public static void main(String[] args) throws InterruptedException {
    List<Data> datas = new ArrayList<>();
    for (int i = 0; i < 10000; i++) {
      datas.add(new Data());
    }
    TimeUnit.SECONDS.sleep(360);
  }

  static class Data {}
}
