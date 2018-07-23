package org.litespring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xp-zhao on 2018/7/23.
 */
public interface Resource
{
	public InputStream getInputStream() throws IOException;
	public String getDescription();
}
