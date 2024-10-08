package com.example.client;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/** @author zhaoxiaoping @Description: 负责发送各种 http 请求的组件 @Date 2021-10-13 */
@Slf4j
public class HttpSender {

  /**
   * 发送注册请求
   *
   * @param request
   * @return
   */
  public RegisterResponse register(RegisterRequest request) {
    // 实际上是基于 HttpClient 这种开源的网络包, 构造一个请求(里面放入服务实例的信息, 包含服务名称, ip, 端口等)
    log.info("服务实例[{}], 发送请求进行注册...", request);
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
    log.info("服务实例[{}]发送请求进行心跳...", request);
    // 收到 register-server 响应之后, 封装响应对象
    HeartbeatResponse response = new HeartbeatResponse();
    response.setStatus(RegisterResponse.SUCCESS);
    return response;
  }

  /**
   * 拉取服务注册表
   *
   * @return 全量的服务注册表
   */
  public Map<String, Map<String, ServiceInstance>> fetchServiceRegistry() {
    Map<String, Map<String, ServiceInstance>> registry = new HashMap<>();
    ServiceInstance serviceInstance = new ServiceInstance();
    serviceInstance.setServiceName("finance-service-01");
    serviceInstance.setIp("192.168.0.1");
    serviceInstance.setPort(9000);
    serviceInstance.setHostname("FINANCE-SERVICE");
    serviceInstance.setServiceInstanceId("FINANCE-SERVICE-192.168.0.1:9000");
    Map<String, ServiceInstance> serviceInstances = new HashMap<>();
    serviceInstances.put("FINANCE-SERVICE-192.168.0.1:9000", serviceInstance);
    registry.put("FINANCE-SERVICE", serviceInstances);
    log.info("拉取注册表: {}", registry);
    return registry;
  }

  /**
   * 服务下线
   *
   * @param serviceName 服务名称
   * @param serviceInstanceId 服务实例id
   */
  public void cancel(String serviceName, String serviceInstanceId) {
    log.info("服务实例下线[{}, {}]", serviceName, serviceInstanceId);
  }
}
