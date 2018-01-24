package com.xp.sso.filter;

import com.xp.sso.constant.AuthConst;
import com.xp.sso.storage.SessionStorage;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by xp-zhao on 2018/1/24.
 */
public class LoginFilter implements Filter
{
	private FilterConfig config;

	public void init(FilterConfig filterConfig) throws ServletException
	{
		config = filterConfig;
	}

	public void doFilter(ServletRequest req , ServletResponse res , FilterChain chain)
		throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();

		if(session.getAttribute(AuthConst.IS_LOGIN) != null)
		{
			chain.doFilter(req,res);
			return;
		}

		String token = request.getParameter(AuthConst.TOKEN);
		if (token != null) {
			session.setAttribute(AuthConst.IS_LOGIN, true);
			session.setAttribute(AuthConst.TOKEN, token);
			// 存储，用于注销
			SessionStorage.INSTANCE.set(token, session);
			chain.doFilter(req, res);
			return;
		}

		// 重定向至登录页面，并附带当前请求地址
		response.sendRedirect(config.getInitParameter(AuthConst.LOGIN_URL) + "?" + AuthConst.CLIENT_URL + "=" + request.getRequestURL());
	}

	public void destroy()
	{
	}
}
