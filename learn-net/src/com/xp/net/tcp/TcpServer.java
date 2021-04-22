package com.xp.net.tcp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/4/22 9:16 下午 */
public class TcpServer {
  public static void main(String[] args) {
    try (ServerSocket server = new ServerSocket(9999)) {
      Socket accept = server.accept();
      try (InputStream inputStream = accept.getInputStream();
          ByteArrayOutputStream os = new ByteArrayOutputStream()) {
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
          os.write(bytes, 0, len);
        }
        System.out.println(os.toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
