package org.tiny.core.io;

import cn.hutool.core.lang.Assert;
import java.net.MalformedURLException;
import java.net.URL;

/** @author zhaoxiaoping @Description: 获取资源接口默认实现 @Date 2021-8-20 */
public class DefaultResourceLoader implements ResourceLoader {

  @Override
  public Resource getResource(String location) {
    Assert.notNull(location, "Location must not be null");
    if (location.startsWith(CLASSPATH_URL_PREFIX)) {
      // 加载 classpath 下的资源
      return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
    } else {
      try {
        // 加载网络资源
        URL url = new URL(location);
        return new UrlResource(url);
      } catch (MalformedURLException e) {
        // 加载文件系统中的资源
        return new FileSystemResource(location);
      }
    }
  }
}
