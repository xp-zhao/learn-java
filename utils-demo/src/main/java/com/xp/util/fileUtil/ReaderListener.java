package com.xp.util.fileUtil;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xp-zhao on 2017/9/22.
 */
public abstract class ReaderListener
{
	// 默认一次读取的行数为 500
	private int readColNum = 500;

	private List<String> list = new ArrayList<String>();

	/**
	 * 设置一次读取的行数
	 * @param readColNum
	 */
	protected void setReadColNum(int readColNum)
	{
		this.readColNum = readColNum;
	}

	public void outLine(String lineStr,long lineNum, boolean over)
	{
		if(StringUtils.isNotEmpty(lineStr))
		{
			list.add(lineStr);
		}
		if(!over && (lineNum % readColNum == 0))
		{
			output(list);
			list.clear();
		}
		else if(over)
		{
			output(list);
			list.clear();
		}
	}

	public abstract void output(List<String> strList);
}
