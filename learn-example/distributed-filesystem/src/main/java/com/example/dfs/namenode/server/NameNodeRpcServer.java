package com.example.dfs.namenode.server;

import lombok.extern.slf4j.Slf4j;

/** @author zhaoxiaoping @Description: namenode 的 rpc 服务接口 @Date 2021-10-25 */
@Slf4j
public class NameNodeRpcServer {

  /** 负责管理元数据的核心组件 */
  private FSNameSystem nameSystem;

  public NameNodeRpcServer(FSNameSystem nameSystem) {
    this.nameSystem = nameSystem;
  }

  /**
   * 创建目录
   *
   * @param path 目录路径
   * @return 是否创建成功
   * @throws Exception
   */
  public Boolean mkdir(String path) throws Exception {
    return this.nameSystem.mkdir(path);
  }

  /** 启动 rpc server */
  public void start() {
    log.info("开始监听指定的 rpc server 端口号, 来接收请求");
  }
}
