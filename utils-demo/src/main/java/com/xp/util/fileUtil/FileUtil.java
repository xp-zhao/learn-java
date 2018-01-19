
package com.xp.util.fileUtil;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xp-zhao on 2017/9/13.
 */
public class FileUtil
{
	private static final Logger logger = Logger.getLogger(FileUtil.class);

	/**
	 * 将处理后的文件移动到指定位置
	 * @param pathName 文件原始位置
	 * @param fileName 文件名称
	 * @param ansPath 文件准备移动到的位置
	 */
	public static void moveTotherFolders(String pathName , String fileName , String ansPath)
	{
		String startPath = pathName + "/" + fileName;
		String endPath = ansPath + "/" + fileName;
		try
		{
			File startFile = new File(startPath);
			File tmpFile = new File(ansPath);//获取文件夹路径
			if(!tmpFile.exists())
			{//判断文件夹是否创建，没有创建则创建新文件夹
				tmpFile.mkdirs();
			}
			if(!startFile.renameTo(new File(endPath)))
			{
				logger.info("文件移动失败");
			}
		}
		catch (Exception e)
		{
			logger.error("文件移动异常！", e);
		}
	}

	/**
	 * 获得某一文件夹下的所有文件的名称集合
	 *
	 * @param filePath 文件夹路径
	 * @return ArrayList，其中的每个元素是一个文件的路径的字符串
	 */
	public static List<String> getFilePathFromFolder(String filePath)
	{
		List<String> fileNames = new ArrayList<>();
		File file = new File(filePath);
		try
		{
			File[] tempFile = file.listFiles();
			for(int i = 0 ; i < tempFile.length ; i++)
			{
				if(tempFile[i].isFile())
				{
					fileNames.add(tempFile[i].getName());
				}
			}
		}
		catch (Exception e)
		{
			logger.error("获取目录 " + filePath + " 下的所有文件失败", e);
		}
		return fileNames;
	}

	/**
	 * 关闭输入流
	 * @param in 输入流
	 */
	public static void closeInputStream(InputStream in)
	{
		if(in != null)
		{
			try
			{
				in.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static void closeReader(Reader read)
	{
		if(read != null)
		{
			try
			{
				read.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static void closeOutputStream(OutputStream fos)
	{
		if(fos != null)
		{
			try
			{
				fos.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

}
