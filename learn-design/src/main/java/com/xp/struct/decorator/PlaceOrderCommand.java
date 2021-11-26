package com.xp.struct.decorator;

/**
 * Created by xp-zhao on 2018/12/13.
 */
public class PlaceOrderCommand implements Command {

  @Override
  public void execute() {
    System.out.println("执行下订单的操作");
  }
}
