package com.xp.net;

import java.net.InetSocketAddress;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/4/21 10:13 下午 */
public class TestInetSocketAddress {
  public static void main(String[] args) {
    //
    InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8080);
    System.out.println(address);
  }
}
