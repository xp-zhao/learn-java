package org.litespring.context.support;

import org.litespring.core.io.FileSystemResource;
import org.litespring.core.io.Resource;

/**
 * Created by xp-zhao on 2018/7/23.
 */
public class FileSystemXmlApplicationContext extends AbstractApplicationContext
{
	public FileSystemXmlApplicationContext(String configFile)
	{
		super(configFile);
	}

	@Override
	protected Resource getResourceByPath(String path)
	{
		return new FileSystemResource(path);
	}
}
