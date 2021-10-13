package com.example.client;

import java.util.UUID;

/** @author zhaoxiaoping @Description: 在各个服务上被创建启动, 负责和 register-server 通信 @Date 2021-10-13 */
public class RegisterClient {

  private String serviceInstanceId;

  public RegisterClient() {
    this.serviceInstanceId = UUID.randomUUID().toString().replace("-", "");
  }

  public void start() {
    // 启动组件之后, 开启一个后台线程向 register-server 发送请求, 注册当前服务
    // 在注册成功之后, 开启另一个线程发送心跳
    new Thread(new RegisterWorker(serviceInstanceId)).start();
  }
}
