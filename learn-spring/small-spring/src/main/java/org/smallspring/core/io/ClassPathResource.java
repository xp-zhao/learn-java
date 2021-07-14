package org.smallspring.core.io;

import cn.hutool.core.lang.Assert;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.smallspring.util.ClassUtils;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-7-14
 **/
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
    InputStream inputStream = classLoader.getResourceAsStream(path);
    if (inputStream == null) {
      throw new FileNotFoundException(
          this.path + " cannot be opened because it does not exist");
    }
    return inputStream;
  }
}
