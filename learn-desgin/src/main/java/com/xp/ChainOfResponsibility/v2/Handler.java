package com.xp.ChainOfResponsibility.v2;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/6/17 10:38 下午 */
public abstract class Handler {
  protected Handler successor = null;

  public void setSuccessor(Handler successor) {
    this.successor = successor;
  }

  public final void handle() {
    boolean handled = doHandle();
    if (successor != null && !handled) {
      successor.handle();
    }
  }

  public abstract boolean doHandle();
}
