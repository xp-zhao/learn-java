package org.litespring.test.v4;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.core.io.Resource;
import org.litespring.core.io.support.PackageResourceLoader;

import java.io.IOException;

/**
 * Created by xp-zhao on 2018/12/23.
 */
public class PackageResourceLoaderTest
{
	@Test
	public void testGetResources() throws IOException
	{
		PackageResourceLoader loader = new PackageResourceLoader();
		Resource[] resources = loader.getResources("org.litespring.dao.v4");
		Assert.assertEquals(2, resources.length);

	}
}
