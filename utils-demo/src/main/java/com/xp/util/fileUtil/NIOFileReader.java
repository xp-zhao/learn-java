package com.xp.util.fileUtil;

import org.apache.log4j.Logger;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by xp-zhao on 2017/9/22.
 */
public class NIOFileReader
{
	private static final Logger logger = Logger.getLogger(NIOFileReader.class);
	private int buffSize = 1024;
	private byte key = "\n".getBytes()[0];
	private long lineNum = 0;
	private String encode = "gb2312";
	private ReaderListener readerListener;

	public NIOFileReader(ReaderListener readerListener)
	{
		this.readerListener = readerListener;
	}

	public NIOFileReader(ReaderListener readerListener,String encode)
	{
		this.encode = encode;
		this.readerListener = readerListener;
	}

	public void normalReadFileByLine(String filePath) throws Exception
	{
		File file = new File(filePath);
		if(file.exists())
		{
			try
			{
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),encode));
				String lineStr;
				while((lineStr = reader.readLine()) != null)
				{
					lineNum++;
					readerListener.outLine(lineStr.trim(),lineNum,false);
				}
				readerListener.outLine(null,lineNum,true);
				reader.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			throw new FileNotFoundException("文件不存在");
		}
	}

	public void readFileByLine(String filePath)
	{
		File file = new File(filePath);
		if(file.exists())
		{
			try
			{
				FileChannel fc = new RandomAccessFile(file,"r").getChannel();
				ByteBuffer bb = ByteBuffer.allocate(buffSize);
				byte[] bs = new byte[buffSize];
				byte[] tempBs = new byte[0];
				String line = "";
				while((fc.read(bb) != -1))
				{
					int rSize = bb.position();

				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
