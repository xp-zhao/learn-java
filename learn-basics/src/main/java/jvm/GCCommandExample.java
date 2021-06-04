package jvm;

import java.util.concurrent.TimeUnit;

/**
 * @Author: xp-zhao
 * @Description: TODO
 * @DateTime: 2021/6/4 11:31 下午
 **/
public class GCCommandExample {
  public static void main(String[] args) throws InterruptedException {
      TimeUnit.SECONDS.sleep(30);
      while (true){
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
