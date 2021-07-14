package org.smallspring.core.io;

import cn.hutool.core.lang.Assert;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-7-14
 **/
public class DefaultResourceLoader implements ResourceLoader {

  @Override
  public Resource getResource(String location) {
    Assert.notNull(location, "Location must not be null");
    if (location.startsWith(CLASSPATH_URL_PREFIX)) {
      return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
    } else {
      try {
        URL url = new URL(location);
        return new UrlResource(url);
      } catch (MalformedURLException e) {
        return new FileSystemResource(location);
      }
    }
  }
}
