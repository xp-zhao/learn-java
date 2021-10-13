package com.example.client;

import java.util.concurrent.TimeUnit;

/** @author zhaoxiaoping @Description: 负责向 register-server 发起注册申请的线程 @Date 2021-10-13 */
public class RegisterWorker implements Runnable {

  private static final String SERVICE_NAME = "inventory-service";
  private static final String IP = "192.168.0.107";
  private static final String HOST_NAME = "inventory01";
  private static final int PORT = 9000;

  /** http 通信组件 */
  private HttpSender httpSender;
  /** 是否完成注册 */
  private boolean finishedRegister;
  /** 服务实例id */
  private String serviceInstanceId;

  public RegisterWorker(String serviceInstanceId) {
    this.httpSender = new HttpSender();
    this.finishedRegister = false;
    this.serviceInstanceId = serviceInstanceId;
  }

  public void run() {
    if (!finishedRegister) {
      // 获取当前机器的的信息, 包含ip, hostname, 配置的服务监听的端口号等
      RegisterRequest registerRequest = new RegisterRequest();
      registerRequest.setServiceName(SERVICE_NAME);
      registerRequest.setIp(IP);
      registerRequest.setPort(PORT);
      registerRequest.setServiceInstanceId(serviceInstanceId);
      RegisterResponse registerResponse = httpSender.register(registerRequest);
      System.out.println("服务注册结果: " + registerResponse.getStatus());
      if (RegisterResponse.SUCCESS.equals(registerResponse.getStatus())) {
        finishedRegister = true;
      } else {
        throw new RuntimeException("服务注册失败");
      }
    }
    if (finishedRegister) {
      // 注册成功, 循环发送心跳请求
      HeartbeatRequest heartbeatRequest = new HeartbeatRequest();
      heartbeatRequest.setServiceName(SERVICE_NAME);
      heartbeatRequest.setServiceInstanceId(serviceInstanceId);
      while (true) {
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
