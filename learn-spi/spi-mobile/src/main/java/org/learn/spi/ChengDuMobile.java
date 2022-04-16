package org.learn.spi;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/4/16
 */
public class ChengDuMobile implements ISpiService {
  @Override
  public void connectInternet() {
    System.out.println("connect internet by [ChengDu Mobile]");
  }
}
