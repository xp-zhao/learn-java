package org.example;

import org.example.protocol.HttpServer;
import org.example.register.LocalRegister;

/**
 * @author xp-zhao
 * @description
 * @date 2023/10/9 22:43
 */
public class Provider {
  public static void main(String[] args) {
    LocalRegister.register(HelloService.class.getName(), "1.0", HelloServiceImpl.class);
    LocalRegister.register(HelloService.class.getName(), "2.0", ByteServiceImpl.class);
    // Netty, Tomcat
    HttpServer httpServer = new HttpServer();
    httpServer.start("localhost", 8080);
  }
}
