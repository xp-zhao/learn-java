package com.xp.adapter;

/**
 * @author zhaoxiaoping
 * @Description: 电脑（没有直接插网线的接口）
 * @Date 2020/4/27
 **/
public class Computer {

  public void net(Adapter adapter) {
    // 上网的具体实现
    adapter.handlerRequest();
  }

  public static void main(String[] args) {
    // 电脑、网线、适配器
    Computer computer = new Computer();
    Adaptee adaptee = new Adaptee();
    Adapter adapter = new NetToUsb(adaptee);
    Adapter adapter2 = new NetToUsb2();
    
    computer.net(adapter);
    computer.net(adapter2);
  }
}
