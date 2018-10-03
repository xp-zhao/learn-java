package org.litespring.test.v2;

import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.support.ClassPathXmlApplicationContext;
import org.litespring.dao.v2.AccountDao;
import org.litespring.dao.v2.ItemDao;
import org.litespring.service.v2.PetStoreService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

		assertTrue(petStore.getAccountDao() instanceof AccountDao);
		assertTrue(petStore.getItemDao() instanceof ItemDao);
		assertEquals("xp",petStore.getOwner());
		assertEquals(2,petStore.getVersion());
	}
}
