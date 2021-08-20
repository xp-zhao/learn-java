package org.tiny;

import cn.hutool.core.io.IoUtil;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Before;
import org.junit.Test;
import org.tiny.core.io.DefaultResourceLoader;
import org.tiny.core.io.Resource;

/** @author zhaoxiaoping @Description: @Date 2021-8-17 */
public class ResourceLoadTest {
  private DefaultResourceLoader resourceLoader;

  @Before
  public void init() {
    resourceLoader = new DefaultResourceLoader();
  }

  @Test
  public void testClasspath() throws IOException {
    Resource resource = resourceLoader.getResource("classpath:important.properties");
    InputStream inputStream = resource.getInputStream();
    String content = IoUtil.readUtf8(inputStream);
    System.out.println(content);
  }

  @Test
  public void testFile() throws IOException {
    Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
    InputStream inputStream = resource.getInputStream();
    String content = IoUtil.readUtf8(inputStream);
    System.out.println(content);
  }

  @Test
  public void testUrl() throws IOException {
    Resource resource = resourceLoader.getResource("https://xxx.com/important.properties");
    InputStream inputStream = resource.getInputStream();
    String content = IoUtil.readUtf8(inputStream);
    System.out.println(content);
  }
}
