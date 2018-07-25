package org.litespring.test.v2;

import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.support.ClassPathXmlApplicationContext;
import org.litespring.service.v2.PetStoreService;

import static org.junit.Assert.assertNotNull;

/**
 * Created by xp-zhao on 2018/7/9.
 */
public class ApplicationContextTestV2
{
	@Test
	public void testGetBeanProperty() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v2.xml");
		PetStoreService petStore = (PetStoreService)ctx.getBean("petStore");
		assertNotNull(petStore);
		assertNotNull(petStore.getAccountDao());
		assertNotNull(petStore.getItemDao());
	}
}
