package com.xp.service;

import com.xp.model.FtpConfig;
import com.xp.utils.FileUtil;
import com.xp.utils.FtpUtil;
import com.xp.utils.SprintUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 上传文件到 FTP
 * Created by xp-zhao on 2018/8/16.
 */
public class FileUpload
{
	public static void upload() throws FileNotFoundException
	{
		FtpConfig config = SprintUtil.getBean("ftpconfig");
		System.out.println("上传文件到 FTP");
		System.out.println(config.toString());
//		File file = new File("D:\\Users\\python3\\code\\print.py");
//		File file = new File("D:\\migu-userGroup\\log\\index.css");
//		boolean flag = FtpUtil.uploadFile(config.getAddress() , Integer.parseInt(config.getPort()) , config.getUsername() ,
//			config.getPassword() , config.getFilepath() , "test" , file.getName() , new FileInputStream(file));
		List<File> files;
		files = FileUtil.getFilePathFromFolder("D:\\Users\\ftp","playlist_20180816");
		ExecutorService service = Executors.newFixedThreadPool(files.size());
		for(int i = 0; i < files.size(); i++)
		{
			service.submit(new UploadThread(files.get(i)));
		}
		service.shutdown();
		while(true)
		{
			if(service.isTerminated())
			{
				System.out.println("文件上传结束：");
				break;
			}
		}
	}
}
