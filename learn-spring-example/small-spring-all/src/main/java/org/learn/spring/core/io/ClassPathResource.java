package org.learn.spring.core.io;

import org.learn.spring.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * classpath 资源
 *
 * @author zhaoxiaoping
 * @date 2023-2-2
 */
public class ClassPathResource implements Resource {
  private final String path;

  private ClassLoader classLoader;

  public ClassPathResource(String path) {
    this(path, null);
  }

  public ClassPathResource(String path, ClassLoader classLoader) {
    this.path = path;
    this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
  }

  @Override
  public InputStream getInputStream() throws IOException {
    InputStream inputStream = classLoader.getResourceAsStream(path);
    if (inputStream == null) {
      throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
    }
    return inputStream;
  }
}
