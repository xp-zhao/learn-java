
package com.xp.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

/**
 * ftp上传工具类 <p>Title: FtpUtil</p> <p>Description: </p>
 */
public class FtpUtil
{
	private static final Logger logger = LogManager.getLogger("mylog");

	/**
	 * Description: 向FTP服务器上传文件
	 * @param host FTP服务器hostname
	 * @param port FTP服务器端口
	 * @param username FTP登录账号
	 * @param password FTP登录密码
	 * @param basePath FTP服务器基础目录
	 * @param filePath
	 *        FTP服务器文件存放路径。例如分日期存放：/2015/01/01。文件的路径为basePath+filePath
	 * @param filename 上传到FTP服务器上的文件名
	 * @param input 输入流
	 * @return 成功返回true，否则返回false
	 */
	public static boolean uploadFile(String host , int port , String username , String password , String basePath ,
		String filePath , String filename , InputStream input)
	{
		boolean result = false;
		FTPClient ftp = new FTPClient();
		try
		{
			int reply;
			ftp.connect(host, port);// 连接FTP服务器
			// 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
			ftp.login(username, password);// 登录
			reply = ftp.getReplyCode();
			if(!FTPReply.isPositiveCompletion(reply))
			{
				ftp.disconnect();
				return result;
			}
			//切换到上传目录
			if(!ftp.changeWorkingDirectory(filePath))
			{
				//如果目录不存在创建目录
				String[] dirs = filePath.split("/");
				for(String dir : dirs)
				{
					if(null == dir || "".equals(dir))
						continue;
					if(!ftp.changeWorkingDirectory(dir))
					{
						if(!ftp.makeDirectory(dir))
						{
							return result;
						}
						else
						{
							ftp.changeWorkingDirectory(dir);
						}
					}
				}
			}
			//设置上传文件的类型为二进制类型
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			//上传文件
//			ftp.enterLocalPassiveMode();
			ftp.setControlEncoding("UTF-8");
			ftp.setFileTransferMode(FTP.BINARY_FILE_TYPE);
			if(!ftp.storeFile(filename, input))
			{
				return result;
			}
			input.close();
			ftp.logout();
			result = true;
		}
		catch (IOException e)
		{
			logger.error("上传文件到 ftp 失败",e);
		}
		finally
		{
			if(ftp.isConnected())
			{
				try
				{
					ftp.disconnect();
				}
				catch (IOException ioe)
				{}
			}
		}
		return result;
	}

	/**
	 * Description: 从FTP服务器下载文件
	 * @param host FTP服务器hostname
	 * @param port FTP服务器端口
	 * @param username FTP登录账号
	 * @param password FTP登录密码
	 * @param remotePath FTP服务器上的相对路径
	 * @param prefix 要下载的文件名前缀
	 * @param localPath 下载后保存到本地的路径
	 * @return
	 */
	public static boolean downloadFile(String host , int port , String username , String password ,
		String remotePath , String prefix , String localPath)
	{
		File local_path = new File(localPath);
		if(!local_path.exists())
		{
			local_path.mkdirs();
		}
		boolean result = false;
		FTPClient ftp = new FTPClient();
		try
		{
			int reply;
			ftp.connect(host, port);
			// 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
			if(ftp.login(username, password))// 登录
			{
				logger.info("FTP登入成功");
			}
			else
			{
				logger.error("FTP登入失败");
			}
			reply = ftp.getReplyCode();
			if(!FTPReply.isPositiveCompletion(reply))
			{
				logger.error("FTP server refused connection：" + reply);
				ftp.disconnect();
				return result;
			}
			else
			{
				logger.info("FTP server connection success：" + reply);
				ftp.setFileType(FTP.BINARY_FILE_TYPE);
				ftp.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
				ftp.setControlEncoding("UTF-8");
//				ftp.enterLocalPassiveMode();
				FTPFile[] fs = ftp.listFiles();
				logger.info("当前目录下文件个数：" + fs.length);
			}
//			if(StringUtils.isNotEmpty(remotePath))
//			{
//				for(String tmp : remotePath.split("/"))
//				{
//					if(!ftp.changeWorkingDirectory(tmp))
//					{
//						logger.info("FTP目录切换失败：" + tmp);
//						return false;
//					}
//				}
//			}
			FTPFile[] fs = ftp.listFiles();
			for(FTPFile ff : fs)
			{
//				logger.info("文件..." + ff.getName());
				if(ff.getName().contains(prefix))
				{
					File localFile = new File(localPath + File.separator + ff.getName());
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(localFile));
					ftp.retrieveFile(ff.getName(), bos);
					bos.close();
					logger.info("文件："+ff.getName() +"下载成功，目录："+localPath+File.separator+ff.getName());
				}
			}
			ftp.logout();
			result = true;
		}
		catch (IOException e)
		{
			logger.error("文件下载失败", e);
			e.printStackTrace();
		}
		finally
		{
			if(ftp.isConnected())
			{
				try
				{
					ftp.disconnect();
				}
				catch (IOException ioe)
				{}
			}
		}
		return result;
	}

	public static void main(String[] args)
	{
		String address = PropertiesUtil.getInstance("ftp").get("ftp.address");
		Integer port = PropertiesUtil.getInstance("ftp").getInt("ftp.port");
		String username = PropertiesUtil.getInstance("ftp").get("ftp.username");
		String password = PropertiesUtil.getInstance("ftp").get("ftp.password");
		String filepath = PropertiesUtil.getInstance("ftp").get("ftp.filepath");

		downloadFile(address,port,username,password,filepath,"test",".");

//		try
//		{
//			FileInputStream in = new FileInputStream(new File(
//				"D:\\migu-userGroup\\log\\index.css"));
//			boolean flag = uploadFile(address, port, username, password, "/", "", "playlist_20170824.txt",
//				in);
//			System.out.println(flag);
//		}
//		catch (FileNotFoundException e)
//		{
//			e.printStackTrace();
//		}
	}
}
