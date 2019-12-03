package org.litespring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author xp-zhao
 * @date 2018/7/23
 */
public interface Resource {

  /**
   * 获取输入流
   *
   * @return 输入流
   * @throws IOException io 异常
   */
  InputStream getInputStream() throws IOException;

  /**
   * 获取资源描述
   *
   * @return 资源描述
   */
  String getDescription();
}
