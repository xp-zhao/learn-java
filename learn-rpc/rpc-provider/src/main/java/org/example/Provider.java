package org.example;

import org.example.common.URL;
import org.example.protocol.HttpServer;
import org.example.register.LocalRegister;
import org.example.register.MapRemoteRegister;

/**
 * @author xp-zhao
 * @description
 * @date 2023/10/9 22:43
 */
public class Provider {
  public static void main(String[] args) {
    // 本地服务注册
    LocalRegister.register(HelloService.class.getName(), "1.0", HelloServiceImpl.class);
    LocalRegister.register(HelloService.class.getName(), "2.0", ByteServiceImpl.class);
    // 服务注册，注册中心注册
    URL url = new URL("localhost", 8080);
    MapRemoteRegister.register(HelloService.class.getName(), url);
    // Netty, Tomcat
    HttpServer httpServer = new HttpServer();
    httpServer.start(url.getHostname(), url.getPort());
  }
}
