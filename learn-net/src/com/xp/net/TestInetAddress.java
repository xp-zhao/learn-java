package com.xp.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/** @Author: xp-zhao @Description: 测试 ip @DateTime: 2021/4/21 9:54 下午 */
public class TestInetAddress {
  public static void main(String[] args) {
    try {
      InetAddress local = InetAddress.getByName("127.0.0.1");
      System.out.println(local);
      InetAddress local1 = InetAddress.getLocalHost();
      System.out.println(local1);
      InetAddress baidu = InetAddress.getByName("www.baidu.com");
      System.out.println(baidu);
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }
}
