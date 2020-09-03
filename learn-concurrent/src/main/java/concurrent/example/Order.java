package concurrent.example;

import java.util.concurrent.TimeUnit;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-3
 **/
public class Order {

  private int pos;
  private int dos;
  private int diff;

  public void getPOrder() {
    // 获取未对账订单
    sleep(3);
    pos = 3;
  }

  public void getDOrder() {
    // 获取派送单
    sleep(3);
    dos = 3;
  }

  public void check() {
    // 对比差异
    sleep(1);
    diff = pos + dos;
  }

  public void save() {
    // 保存差异
    sleep(2);
    System.out.println(diff);
  }

  private void sleep(long time) {
    try {
      TimeUnit.SECONDS.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public int getPos() {
    return pos;
  }

  public void setPos(int pos) {
    this.pos = pos;
  }

  public int getDos() {
    return dos;
  }

  public void setDos(int dos) {
    this.dos = dos;
  }
}
