package com.example.dfs.namenode.server;

/** @author zhaoxiaoping @Description: 负责管理元数据的核心组件 @Date 2021-10-25 */
public class FSNameSystem {
  private FSDirectory directory;
  private FSEditLog editlog;

  public FSNameSystem() {
    this.directory = new FSDirectory();
    this.editlog = new FSEditLog();
  }

  /**
   * 创建目录
   *
   * @param path 目录路径
   * @return 是否创建成功
   * @throws Exception
   */
  public Boolean mkdir(String path) throws Exception {
    this.directory.mkdir(path);
    this.editlog.logEdit("创建目录: " + path);
    return true;
  }
}
