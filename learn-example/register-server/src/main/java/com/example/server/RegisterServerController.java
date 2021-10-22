package com.example.server;

import java.util.Map;

/** @author zhaoxiaoping @Description: 服务注册控制层 @Date 2021-10-13 */
public class RegisterServerController {

  private ServiceRegistry serviceRegistry = ServiceRegistry.getInstance();

  /**
   * 服务注册
   *
   * @param registerRequest 注册请求
   * @return 注册响应
   */
  public RegisterResponse register(RegisterRequest registerRequest) {
    RegisterResponse registerResponse = new RegisterResponse();
    try {
      ServiceInstance serviceInstance = new ServiceInstance();
      serviceInstance.setServiceName(registerRequest.getServiceName());
      serviceInstance.setIp(registerRequest.getIp());
      serviceInstance.setPort(registerRequest.getPort());
      serviceInstance.setHostname(registerRequest.getHostname());
      serviceInstance.setServiceInstanceId(registerRequest.getServiceInstanceId());
      // 注册
      serviceRegistry.register(serviceInstance);

      registerResponse.setStatus(RegisterResponse.SUCCESS);
    } catch (Exception e) {
      registerResponse.setStatus(RegisterResponse.FAILURE);
    }
    return registerResponse;
  }

  /**
   * 心跳
   *
   * @param heartbeatRequest 心跳请求
   * @return 心跳响应
   */
  public HeartbeatResponse heartbeat(HeartbeatRequest heartbeatRequest) {
    HeartbeatResponse heartbeatResponse = new HeartbeatResponse();
    try {
      // 对服务实例进行续约
      ServiceInstance serviceInstance =
          serviceRegistry.getServiceInstance(
              heartbeatRequest.getServiceName(), heartbeatRequest.getServiceInstanceId());
      serviceInstance.renew();
      // 记录一下每分钟的心跳次数
      HeartbeatMeasuredRate heartbeatMeasuredRate = new HeartbeatMeasuredRate();
      heartbeatMeasuredRate.increment();
      heartbeatResponse.setStatus(HeartbeatResponse.SUCCESS);
    } catch (Exception e) {
      e.printStackTrace();
      heartbeatResponse.setStatus(HeartbeatResponse.FAILURE);
    }
    return heartbeatResponse;
  }

  /**
   * 拉取服务注册表
   *
   * @return
   */
  public Map<String, Map<String, ServiceInstance>> fetchServiceRegistry() {
    return serviceRegistry.getRegistry();
  }
}
