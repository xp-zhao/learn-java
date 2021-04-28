package com.xp.composite.v2;

/** @Author: xp-zhao @Description: 文件系统节点对象 @DateTime: 2021/4/23 10:05 下午 */
public abstract class FileSystemNode {
  protected String path;

  public FileSystemNode(String path) {
    this.path = path;
  }

  /**
   * 文件数量
   *
   * @return
   */
  public abstract int countNumOfFiles();

  /**
   * 文件大小
   *
   * @return
   */
  public abstract long countSizeOfFiles();

  public String getPath() {
    return path;
  }
}
