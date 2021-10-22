package com.example.server;

import java.util.HashMap;
import java.util.Map;

/** @author zhaoxiaoping @Description: 服务注册表 @Date 2021-10-13 */
public class ServiceRegistry {

  /** 注册表是单例 */
  private static ServiceRegistry instance = new ServiceRegistry();

  private ServiceRegistry() {}

  /**
   * 核心的内存数据结构: 注册表<br>
   * Map: key 是服务名称, value 是这个服务的所有服务实例<br>
   * Map<String, ServiceInstance>: key 是服务实例id, value 是服务实例的信息<br>
   */
  private Map<String, Map<String, ServiceInstance>> registry = new HashMap<>();

  /**
   * 服务注册
   *
   * @param serviceInstance 服务实例
   */
  public void register(ServiceInstance serviceInstance) {
    registry
        .computeIfAbsent(serviceInstance.getServiceName(), v -> new HashMap<>(1))
        .put(serviceInstance.getServiceInstanceId(), serviceInstance);
    System.out.println("服务实例[" + serviceInstance + "], 完成注册...");
    System.out.println("注册表: " + registry);
  }

  /**
   * 从注册表删除一个服务实例
   *
   * @param serviceName
   * @param serviceInstanceId
   */
  public void remove(String serviceName, String serviceInstanceId) {
    System.out.println("服务实例[" + serviceInstanceId + "], 从注册表中删除");
    registry.get(serviceName).remove(serviceInstanceId);
  }

  /**
   * 获取服务实例
   *
   * @param serviceName 服务名称
   * @param serviceInstanceId 服务实例id
   * @return 服务实例
   */
  public ServiceInstance getServiceInstance(String serviceName, String serviceInstanceId) {
    return registry.get(serviceName).get(serviceInstanceId);
  }

  /**
   * 获取整个注册表
   *
   * @return 注册表
   */
  public Map<String, Map<String, ServiceInstance>> getRegistry() {
    return registry;
  }

  public static ServiceRegistry getInstance() {
    return instance;
  }
}
