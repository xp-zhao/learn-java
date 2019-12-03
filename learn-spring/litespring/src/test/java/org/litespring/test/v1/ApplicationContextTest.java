package org.litespring.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.support.ClassPathXmlApplicationContext;
import org.litespring.context.support.FileSystemXmlApplicationContext;
import org.litespring.service.v1.PetStoreService;

/**
 * Created by xp-zhao on 2018/7/9.
 */
public class ApplicationContextTest {

  @Test
  public void testGetBean() {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v1.xml");
    PetStoreService petStore = (PetStoreService) ctx.getBean("petStore");
    Assert.assertNotNull(petStore);
  }

  @Test
  public void testGetBeanFromFileSystemContext() {
    ApplicationContext ctx = new FileSystemXmlApplicationContext(
        "src\\test\\resources\\petstore-v1.xml");
    PetStoreService petStore = (PetStoreService) ctx.getBean("petStore");
    Assert.assertNotNull(petStore);

  }
}
