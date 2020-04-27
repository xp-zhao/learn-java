package com.xp.adapter;

/**
 * @author zhaoxiaoping
 * @Description: 真正的适配器
 * @Date 2020/4/27
 **/
public class NetToUsb implements Adapter {

  private Adaptee adaptee;

  public NetToUsb(Adaptee adaptee) {
    this.adaptee = adaptee;
  }

  @Override
  public void handlerRequest() {
    adaptee.request();
  }
}
