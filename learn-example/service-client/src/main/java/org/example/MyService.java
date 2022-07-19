package org.example;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/7/19
 */
public class MyService implements IService {
  @Override
  public void start() {
    System.out.println("start Service[" + this + ']');
    System.out.println("热加载示例");
  }

  @Override
  public void end() {
    System.out.println("stop Service[" + this + ']');
  }
}
