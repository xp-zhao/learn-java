package com.xp.service;

import com.xp.model.FtpConfig;
import com.xp.utils.FtpUtil;
import com.xp.utils.SprintUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by xp-zhao on 2018/8/16.
 */
public class UploadThread implements Runnable
{
	private File file;

	public UploadThread(File file)
	{
		this.file = file;
	}

	@Override
	public void run()
	{
		FtpConfig config = SprintUtil.getBean("ftpconfig");
		try
		{
			boolean flag = FtpUtil.uploadFile(config.getAddress() , Integer.parseInt(config.getPort()) , config.getUsername() ,
							config.getPassword() , config.getFilepath() , "playlist" , file.getName() , new FileInputStream(file));
			System.out.println("上传文件结束："+flag);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("文件没找到");
		}
	}
}
