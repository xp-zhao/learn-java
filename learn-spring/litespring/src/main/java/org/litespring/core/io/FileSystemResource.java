package org.litespring.core.io;

import org.litespring.util.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author xp-zhao
 * @date 2018/7/23
 */
public class FileSystemResource implements Resource
{
	private final String path;
	private final File   file;

	public FileSystemResource(File file) {
		this.path = file.getPath();
		this.file = file;
	}

	public FileSystemResource(String path) {
		Assert.notNull(path, "Path must not be null");
		this.file = new File(path);
		this.path = path;
	}

	@Override
  public InputStream getInputStream() throws IOException
	{
		return new FileInputStream(this.file);
	}

	public String getDescription() {
		return "file [" + this.file.getAbsolutePath() + "]";
	}
}
