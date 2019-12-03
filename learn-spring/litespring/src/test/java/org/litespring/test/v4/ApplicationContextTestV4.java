package org.litespring.test.v4;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.support.ClassPathXmlApplicationContext;
import org.litespring.service.v4.PetStoreService;

/**
 * Created by xp-zhao on 2018/12/15.
 */
public class ApplicationContextTestV4 {

  @Test
  public void testGetBeanProperty() {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v4.xml");
    PetStoreService petStore = (PetStoreService) ctx.getBean("petStore");

    Assert.assertNotNull(petStore.getAccountDao());
    Assert.assertNotNull(petStore.getItemDao());
  }
}
