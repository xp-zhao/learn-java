package org.learn.spring.core.io;

import org.learn.spring.beans.BeansException;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-2
 */
public interface Resource {

  /**
   * 获取资源输入流
   *
   * @return
   * @throws BeansException
   */
  InputStream getInputStream() throws IOException;
}
