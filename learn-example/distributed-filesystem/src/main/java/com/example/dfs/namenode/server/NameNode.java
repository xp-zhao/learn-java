package com.example.dfs.namenode.server;

/** @author zhaoxiaoping @Description: NameNode核心启动类 @Date 2021-10-25 */
public class NameNode {

  /** namenode 运行状态 */
  private volatile Boolean shouldRun;
  /** 负责管理元数据的核心组件 */
  private FSNameSystem nameSystem;
  /** NameNode 对外提供 rpc 接口的服务, 响应请求 */
  private NameNodeRpcServer rpcServer;

  public NameNode() {
    this.shouldRun = true;
  }

  /** 初始化 NameNode */
  private void initialize() {
    this.nameSystem = new FSNameSystem();
    this.rpcServer = new NameNodeRpcServer(this.nameSystem);
    this.rpcServer.start();
  }

  private void run() {
    try {
      while (shouldRun) {
        Thread.sleep(10 * 1000);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    NameNode namenode = new NameNode();
    namenode.initialize();
    namenode.run();
  }
}
