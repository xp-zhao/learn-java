package org.learn.spring.core.io;

/**
 * 资源加载接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-2
 */
public interface ResourceLoader {
  /** Pseudo URL prefix for loading from the class path: "classpath:" */
  String CLASSPATH_URL_PREFIX = "classpath:";

  /**
   * 获取资源
   *
   * @param location 资源位置
   * @return
   */
  Resource getResource(String location);
}
