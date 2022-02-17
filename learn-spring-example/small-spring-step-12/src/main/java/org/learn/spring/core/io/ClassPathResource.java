package org.learn.spring.core.io;

import cn.hutool.core.lang.Assert;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.learn.spring.util.ClassUtils;

/**
 * classpath 资源读取实现
 *
 * @author xp-zhao
 * @date 2022/1/4
 */
public class ClassPathResource implements Resource {
  private final String path;

  private ClassLoader classLoader;

  public ClassPathResource(String path) {
    this(path, null);
  }

  public ClassPathResource(String path, ClassLoader classLoader) {
    Assert.notNull(path, "Path must not be null");
    this.path = path;
    this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
  }

  @Override
  public InputStream getInputStream() throws IOException {
    InputStream is = classLoader.getResourceAsStream(path);
    if (is == null) {
      throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
    }
    return is;
  }
}
