package org.tiny.core.io;

/** @author zhaoxiaoping @Description: 资源获取接口 @Date 2021-8-20 */
public interface ResourceLoader {

  /** classpath 默认前缀 */
  String CLASSPATH_URL_PREFIX = "classpath:";

  /**
   * 通过资源地址获取资源
   *
   * @param location 资源地址
   * @return 资源信息
   */
  Resource getResource(String location);
}
