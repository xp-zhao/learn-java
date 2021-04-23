package com.xp.composite.v2;

import java.util.ArrayList;
import java.util.List;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/4/23 10:09 下午 */
public class Directory extends FileSystemNode {

  private List<FileSystemNode> subNodes = new ArrayList<>();

  public Directory(String path) {
    super(path);
  }

  @Override
  public int countNumOfFiles() {
    return subNodes.stream().map(FileSystemNode::countNumOfFiles).reduce(0, Integer::sum);
  }

  @Override
  public long countSizeOfFiles() {
    return subNodes.stream().map(FileSystemNode::countSizeOfFiles).reduce(0L, Long::sum);
  }

  public void addSubNode(FileSystemNode fileOrDir) {
    subNodes.add(fileOrDir);
  }

  public void removeSubNode(FileSystemNode fileSystemNode) {
    int size = subNodes.size();
    int i = 0;
    for (; i < size; i++) {
      if (subNodes.get(i).getPath().equalsIgnoreCase(fileSystemNode.getPath())) {
        break;
      }
    }
    if (i < size) {
      subNodes.remove(i);
    }
  }
}
