package com.example.client;

import java.util.HashMap;
import java.util.Map;

/** @author zhaoxiaoping @Description: 客户端缓存的服务注册表 @Date 2021-10-22 */
public class ClientCachedServiceRegistry {

  /** 服务注册表拉取间隔 */
  private static final Long SERVICE_REGISTRY_FETCH_INTERVAL = 30 * 1000L;

  /** 客户端缓存的服务注册表 */
  private Map<String, Map<String, ServiceInstance>> registry = new HashMap<>();

  /** 负责定时拉取注册表到客户端缓存的线程 */
  private Daemon daemon;

  private RegisterClient registerClient;
  /** 通信组件 */
  private HttpSender httpSender;

  public ClientCachedServiceRegistry(RegisterClient registerClient) {
    this.daemon = new Daemon();
    this.registerClient = registerClient;
    this.httpSender = new HttpSender();
  }

  /** 初始化 */
  public void initialize() {
    this.daemon.start();
  }

  /** 销毁这个组件 */
  public void destroy() {
    this.daemon.interrupt();
  }

  /**
   * 获取服务注册表
   *
   * @return
   */
  public Map<String, Map<String, ServiceInstance>> getRegistry() {
    return registry;
  }

  private class Daemon extends Thread {
    @Override
    public void run() {
      while (registerClient.isRunning()) {
        try {
          registry = httpSender.fetchServiceRegistry();
          Thread.sleep(SERVICE_REGISTRY_FETCH_INTERVAL);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
