package org.learn.spring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源加载接口
 *
 * @author xp-zhao
 * @date 2022/1/4
 */
public interface Resource {
  /**
   * 获取输入流
   *
   * @return {@link InputStream}
   * @throws IOException ioexception
   */
  InputStream getInputStream() throws IOException;
}
