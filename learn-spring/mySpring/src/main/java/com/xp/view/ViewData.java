package com.xp.view;

import com.xp.utils.WebContext;

import javax.servlet.http.HttpServletRequest;

/**
 * 需要发送到客户端显示的数据模型
 * Created by xp-zhao on 2018/4/13.
 */
public class ViewData
{
	private HttpServletRequest request;

	public ViewData()
	{
		initRequest();
	}

	private void initRequest()
	{
		this.request = WebContext.requestHodler.get();
	}

	public void put(String name,Object value)
	{
		this.request.setAttribute(name,value);
	}
}
