package com.example.server;

import java.util.Map;

public class RegistryTest {
  public static void main(String[] args) {
    ServiceRegistry serviceRegistry = ServiceRegistry.getInstance();
    ServiceInstance service01 = new ServiceInstance();
    service01.setServiceName("service01");
    service01.setServiceInstanceId("1001");
    ServiceInstance service02 = new ServiceInstance();
    service02.setServiceName("service01");
    service02.setServiceInstanceId("1002");
    ServiceInstance service03 = new ServiceInstance();
    service03.setServiceName("service03");
    service03.setServiceInstanceId("1001");
    serviceRegistry.register(service01);
    serviceRegistry.register(service02);
    serviceRegistry.register(service03);
    Map<String, Map<String, ServiceInstance>> map = serviceRegistry.getRegistry();
    System.out.println(map);
  }
}
