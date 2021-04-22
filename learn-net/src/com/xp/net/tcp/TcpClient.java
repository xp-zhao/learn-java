package com.xp.net.tcp;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/4/22 9:15 下午 */
public class TcpClient {
  public static void main(String[] args) {
    try {
      InetAddress ip = InetAddress.getByName("127.0.0.1");
      Integer port = 9999;
      try (Socket socket = new Socket(ip, port);
          OutputStream outputStream = socket.getOutputStream()) {
        outputStream.write("Socket 测试".getBytes());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
