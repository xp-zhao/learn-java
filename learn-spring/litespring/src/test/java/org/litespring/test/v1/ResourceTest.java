package org.litespring.test.v1;

import java.io.InputStream;
import org.junit.Assert;
import org.junit.Test;
import org.litespring.core.io.ClassPathResource;
import org.litespring.core.io.FileSystemResource;
import org.litespring.core.io.Resource;

/**
 * Created by xp-zhao on 2018/7/23.
 */
public class ResourceTest {

  @Test
  public void testClassPathResource() throws Exception {
    Resource r = new ClassPathResource("petstore-v1.xml");
    try (InputStream is = r.getInputStream()) {
      // 注意：这个测试其实并不充分！！，只判断了输入流是否为空，并没有验证里面的内容是否正确
      Assert.assertNotNull(is);
    }
  }

  @Test
  public void testFileSystemResource() throws Exception {
    Resource r = new FileSystemResource("src\\test\\resources\\petstore-v1.xml");
    try (InputStream is = r.getInputStream()) {
      // 注意：这个测试其实并不充分！！，只判断了输入流是否为空，并没有验证里面的内容是否正确
      Assert.assertNotNull(is);
    }
  }
}
