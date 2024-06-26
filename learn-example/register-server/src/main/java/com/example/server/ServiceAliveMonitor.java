package com.example.server;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/** @author zhaoxiaoping @Description: 微服务存活状态监控组件 @Date 2021-10-13 */
public class ServiceAliveMonitor {

  /** 检查服务实例是否存活的间隔 */
  private static final Long CHECK_ALIVE_INTERVAL = 60 * 1000L;

  private Daemon daemon;

  public ServiceAliveMonitor() {
    daemon = new Daemon();
    daemon.setDaemon(true);
  }

  /** 启动后台线程 */
  public void start() {
    daemon.start();
  }

  /** 负责监控微服务存活状态的后台线程 */
  private class Daemon extends Thread {
    ServiceRegistry serviceRegistry = ServiceRegistry.getInstance();

    @Override
    public void run() {
      Map<String, Map<String, ServiceInstance>> registryMap = null;
      while (true) {
        try {
          // 判断一下是否开启自我保护机制
          SelfProtectionPolicy selfProtectionPolicy = SelfProtectionPolicy.getInstance();
          if (selfProtectionPolicy.isEnable()) {
            TimeUnit.MILLISECONDS.sleep(CHECK_ALIVE_INTERVAL);
            continue;
          }
          registryMap = this.serviceRegistry.getRegistry();
          registryMap.forEach(
              (serviceName, serviceInstanceMap) -> {
                serviceInstanceMap.forEach(
                    (serviceInstanceId, serviceInstance) -> {
                      if (!serviceInstance.isAlive()) {
                        // 服务实例距离上一次发送心跳已经超过 90s
                        // 从注册表中删除
                        serviceRegistry.remove(serviceName, serviceInstanceId);
                      }
                    });
              });
          TimeUnit.MILLISECONDS.sleep(CHECK_ALIVE_INTERVAL);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
