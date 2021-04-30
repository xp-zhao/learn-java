package com.xp.struct.decorator;

/**
 * Created by xp-zhao on 2018/12/13.
 */
public class PaymentCommand implements Command {

  @Override
  public void execute() {
    System.out.println("执行支付操作");
  }
}
