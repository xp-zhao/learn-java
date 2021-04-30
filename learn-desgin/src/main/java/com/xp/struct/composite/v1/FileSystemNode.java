package com.xp.struct.composite.v1;

import lombok.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/** @Author: xp-zhao @Description: 文件系统节点 @DateTime: 2021/4/23 8:22 下午 */
@Data
public class FileSystemNode {
  private String path;
  private boolean isFile;
  private List<FileSystemNode> subNodes = new ArrayList<>();

  public FileSystemNode(String path, boolean isFile) {
    this.path = path;
    this.isFile = isFile;
  }

  /**
   * 统计当前目录下文件大小
   *
   * @return
   */
  public long countSizeOfFiles() {
    if (isFile) {
      File file = new File(path);
      if (!file.exists()) {
        return 0;
      }
      return file.length();
    }
    long sizeOfFiles = 0;
    for (FileSystemNode subNode : subNodes) {
      sizeOfFiles += subNode.countSizeOfFiles();
    }
    return sizeOfFiles;
  }

  /**
   * 统计当前目录下文件个数
   *
   * @return
   */
  public int countNumOfFiles() {
    if (isFile) {
      return 1;
    }
    int numOfFiles = 0;
    for (FileSystemNode subNode : subNodes) {
      numOfFiles += subNode.countNumOfFiles();
    }
    return numOfFiles;
  }

  /**
   * 添加一个字节点
   *
   * @param fileOrDir
   */
  public void addSubNode(FileSystemNode fileOrDir) {
    subNodes.add(fileOrDir);
  }

  /**
   * 删除一个字节点
   *
   * @param fileOrDir
   */
  public void removeSubNode(FileSystemNode fileOrDir) {
    int size = subNodes.size();
    int i = 0;
    for (; i < size; i++) {
      if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())) {
        break;
      }
    }
    if (i < size) {
      subNodes.remove(i);
    }
  }
}
