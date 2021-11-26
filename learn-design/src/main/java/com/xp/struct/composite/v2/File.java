package com.xp.struct.composite.v2;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/4/23 10:07 下午 */
public class File extends FileSystemNode {
  public File(String path) {
    super(path);
  }

  @Override
  public int countNumOfFiles() {
    return 1;
  }

  @Override
  public long countSizeOfFiles() {
    java.io.File file = new java.io.File(path);
    if (!file.exists()) {
      return 0;
    }
    return file.length();
  }
}
