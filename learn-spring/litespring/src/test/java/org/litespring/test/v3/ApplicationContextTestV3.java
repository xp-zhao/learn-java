package org.litespring.test.v3;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.support.ClassPathXmlApplicationContext;
import org.litespring.service.v3.PetStoreService;

/**
 * Created by xp-zhao on 2018/12/15.
 */
public class ApplicationContextTestV3 {

  @Test
  public void testGetBeanProperty() {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v3.xml");
    PetStoreService petStore = (PetStoreService) ctx.getBean("petStore");

    Assert.assertNotNull(petStore.getAccountDao());
    Assert.assertNotNull(petStore.getItemDao());
    Assert.assertEquals(1, petStore.getVersion());

  }
}
