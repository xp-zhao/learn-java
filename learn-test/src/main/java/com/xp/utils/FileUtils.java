package com.xp.utils;

import java.io.File;

/**
 * Created by xp-zhao on 2018/9/10.
 */
public class FileUtils
{
	public static void deleteFile(File file)
	{
		if(file == null)
		{
			return;
		}
		else if(file.exists())
		{
			if(file.isFile())
			{
				file.delete();
			}
			else if(file.isDirectory())
			{
				String[] str = file.list();
				if(str == null)
				{
					file.delete();
				}
				else
				{
					for(String s : str)
					{
						deleteFile(new File(file , s));
					}
					file.delete();
				}
			}
		}
	}
}
