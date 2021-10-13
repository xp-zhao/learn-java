package com.example.client;

/** @author zhaoxiaoping @Description: 负责发送各种 http 请求的组件 @Date 2021-10-13 */
public class HttpSender {

  /**
   * 发送注册请求
   *
   * @param request
   * @return
   */
  public RegisterResponse register(RegisterRequest request) {
    // 实际上是基于 HttpClient 这种开源的网络包, 构造一个请求(里面放入服务实例的信息, 包含服务名称, ip, 端口等)
    System.out.println("服务实例[" + request + "], 发送请求进行注册...");
    // 收到 register-server 响应之后, 封装响应对象
    RegisterResponse response = new RegisterResponse();
    response.setStatus(RegisterResponse.SUCCESS);
    return response;
  }

  /**
   * 发送心跳请求
   *
   * @param request
   * @return
   */
  public HeartbeatResponse heartbeat(HeartbeatRequest request) {
    // 实际上是基于 HttpClient 这种开源的网络包, 构造一个请求(里面放入服务实例的信息, 包含服务名称, ip, 端口等)
    System.out.println("服务实例[" + request + "]发送请求进行心跳...");
    // 收到 register-server 响应之后, 封装响应对象
    HeartbeatResponse response = new HeartbeatResponse();
    response.setStatus(RegisterResponse.SUCCESS);
    return response;
  }
}
