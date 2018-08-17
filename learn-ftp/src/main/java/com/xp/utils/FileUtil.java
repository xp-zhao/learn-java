package com.xp.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xp-zhao on 2018/8/16.
 */
public class FileUtil
{
	private static final Logger logger = LogManager.getLogger("mylog");
	/**
	 * 获得某一文件夹下指定前缀的所有文件的名称集合
	 *
	 * @param filePath 文件夹路径
	 * @return ArrayList，其中的每个元素是一个文件的路径的字符串
	 */
	public static List<File> getFilePathFromFolder(String filePath, String prefix)
	{
		List<File> files = new ArrayList<>();
		File file = new File(filePath);
		try
		{
			File[] tempFile = file.listFiles();
			for(int i = 0 ; i < tempFile.length ; i++)
			{
				if(tempFile[i].isFile() && tempFile[i].getName().startsWith(prefix))
				{
					files.add(tempFile[i]);
				}
			}
		}
		catch (Exception e)
		{
			logger.error("获取目录 " + filePath + " 下的所有文件失败", e);
		}
		return files;
	}
}
