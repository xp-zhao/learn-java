package com.example.server;

/** @author zhaoxiaoping @Description: 服务注册控制层 @Date 2021-10-13 */
public class RegisterServerController {

  private Registry registry = Registry.getInstance();

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
      registry.register(serviceInstance);

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
      ServiceInstance serviceInstance =
          registry.getServiceInstance(
              heartbeatRequest.getServiceName(), heartbeatRequest.getServiceInstanceId());
      serviceInstance.renew();
      heartbeatResponse.setStatus(HeartbeatResponse.SUCCESS);
    } catch (Exception e) {
      e.printStackTrace();
      heartbeatResponse.setStatus(HeartbeatResponse.FAILURE);
    }
    return heartbeatResponse;
  }
}
