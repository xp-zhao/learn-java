package com.example.server;

import java.util.UUID;

public class RegisterServerControllerTest {
  public static void main(String[] args) {
    RegisterServerController controller = new RegisterServerController();
    // 模拟发起一个服务注册请求
    RegisterRequest registerRequest = new RegisterRequest();
    registerRequest.setServiceName("inventory-service");
    registerRequest.setIp("192.168.0.101");
    registerRequest.setPort(9000);
    String serviceInstanceId = UUID.randomUUID().toString().replace("-", "");
    registerRequest.setServiceInstanceId(serviceInstanceId);
    registerRequest.setHostname("inventory-service-01");
    controller.register(registerRequest);
    // 模拟心跳
    HeartbeatRequest heartbeatRequest = new HeartbeatRequest();
    heartbeatRequest.setServiceName("inventory-service");
    heartbeatRequest.setServiceInstanceId(serviceInstanceId);
    controller.heartbeat(heartbeatRequest);
  }
}