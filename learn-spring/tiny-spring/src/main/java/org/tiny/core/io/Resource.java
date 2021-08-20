package org.tiny.core.io;

import java.io.IOException;
import java.io.InputStream;

/** @author zhaoxiaoping @Description: 资源加载接口 @Date 2021-8-20 */
public interface Resource {

  /**
   * 获取资源输入流
   *
   * @return 资源输入流
   * @throws IOException 获取失败时抛出
   */
  InputStream getInputStream() throws IOException;
}
