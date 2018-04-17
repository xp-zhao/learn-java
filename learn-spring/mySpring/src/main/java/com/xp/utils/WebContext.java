package com.xp.utils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用来存储当前线程中的 HttpServletRequest 和 HttpServletResponse，
 * 其它地方需要使用时就可以通过 requestHodler 和 responseHodler 获取
 * Created by xp-zhao on 2018/4/12.
 */
public class WebContext
{
	public static ThreadLocal<HttpServletRequest> requestHodler = new ThreadLocal<HttpServletRequest>();
	public static ThreadLocal<HttpServletResponse> responseHodler = new ThreadLocal<HttpServletResponse>();

	public HttpServletRequest getRequest()
	{
		return requestHodler.get();
	}

	public HttpSession getSession()
	{
		return requestHodler.get().getSession();
	}

	public ServletContext getServletContext()
	{
		return requestHodler.get().getSession().getServletContext();
	}

	public HttpServletResponse getResponse()
	{
		return responseHodler.get();
	}
}
