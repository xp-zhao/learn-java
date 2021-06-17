package com.xp.ChainOfResponsibility.v2;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/6/17 10:41 下午 */
public class HandlerChain {
  private Handler head = null;
  private Handler tail = null;

  public void addHandler(Handler handler) {
    handler.setSuccessor(null);
    if (head == null) {
      head = handler;
      tail = handler;
      return;
    }
    tail.setSuccessor(handler);
    tail = handler;
  }

  public void handle() {
    if (head != null) {
      head.doHandle();
    }
  }
}
