package org.smallspring.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-7-14
 **/
public class FileSystemResource implements Resource {

  private final File file;
  private final String path;

  public FileSystemResource(File file) {
    this.file = file;
    this.path = file.getPath();
  }

  public FileSystemResource(String path) {
    this.file = new File(path);
    this.path = path;
  }


  @Override
  public InputStream getInputStream() throws IOException {
    return new FileInputStream(this.file);
  }

  public String getPath() {
    return path;
  }
}
