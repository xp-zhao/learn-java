package com.xp.ChainOfResponsibility.v2;

/**
 * @Author: xp-zhao
 * @Description: TODO
 * @DateTime: 2021/6/17 10:46 下午
 **/
public class Client {
  public static void main(String[] args) {
    HandlerChain handlerChain = new HandlerChain();
    handlerChain.addHandler(new HandlerA());
    handlerChain.addHandler(new HandlerB());
    handlerChain.handle();
  }
}
