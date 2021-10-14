package com.example.client;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/** @author zhaoxiaoping @Description: 在各个服务上被创建启动, 负责和 register-server 通信 @Date 2021-10-13 */
public class RegisterClient {

  private static final String SERVICE_NAME = "inventory-service";
  private static final String IP = "192.168.0.107";
  private static final String HOST_NAME = "inventory01";
  private static final int PORT = 9000;

  /** http 通信组件 */
  private HttpSender httpSender;
  /** 服务实例id */
  private String serviceInstanceId;
  /** 心跳线程 */
  private HeartbeatWorker heartbeatWorker;
  /** 服务实例运行状态 */
  private Boolean isRunning;

  public RegisterClient() {
    this.serviceInstanceId = UUID.randomUUID().toString().replace("-", "");
    this.httpSender = new HttpSender();
    this.heartbeatWorker = new HeartbeatWorker();
    this.isRunning = true;
  }

  /** 启动 Register-Client 组件 */
  public void start() {
    // 启动组件之后, 开启一个后台线程向 register-server 发送请求, 注册当前服务
    // 在注册成功之后, 开启另一个线程发送心跳
    try {
      RegisterWorker registerWorker = new RegisterWorker();
      registerWorker.start();
      // 等待注册线程完成之后, 在开启心跳线程
      registerWorker.join();
      heartbeatWorker.start();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /** 停止 Register-Client 组件 */
  public void showdown() {
    this.isRunning = false;
    this.heartbeatWorker.interrupt();
  }

  /** 服务注册线程 */
  private class RegisterWorker extends Thread {
    @Override
    public void run() {
      // 获取当前机器的的信息, 包含ip, hostname, 配置的服务监听的端口号等
      RegisterRequest registerRequest = new RegisterRequest();
      registerRequest.setServiceName(SERVICE_NAME);
      registerRequest.setIp(IP);
      registerRequest.setPort(PORT);
      registerRequest.setServiceInstanceId(serviceInstanceId);
      RegisterResponse registerResponse = httpSender.register(registerRequest);
      System.out.println("服务注册结果: " + registerResponse.getStatus());
    }
  }

  /** 心跳线程 */
  private class HeartbeatWorker extends Thread {
    @Override
    public void run() {
      // 注册成功, 循环发送心跳请求
      HeartbeatRequest heartbeatRequest = new HeartbeatRequest();
      heartbeatRequest.setServiceName(SERVICE_NAME);
      heartbeatRequest.setServiceInstanceId(serviceInstanceId);
      while (isRunning) {
        HeartbeatResponse heartbeatResponse = httpSender.heartbeat(heartbeatRequest);
        System.out.println("心跳检测结果: " + heartbeatResponse.getStatus());
        try {
          TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
