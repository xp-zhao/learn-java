package com.xp.sso.filter;

import com.xp.sso.constant.AuthConst;
import com.xp.sso.storage.ClientStorage;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by xp-zhao on 2018/1/24.
 */
public class SessionFilter implements Filter
{
	public void init(FilterConfig filterConfig) throws ServletException
	{
	}

	public void doFilter(ServletRequest request , ServletResponse response , FilterChain chain)
		throws IOException, ServletException
	{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String uri = req.getRequestURI();

		if("/logout".equals(uri))
		{
			chain.doFilter(request,response);
			return;
		}

		if(session.getAttribute(AuthConst.IS_LOGIN) != null)
		{
			String clientUrl = req.getParameter(AuthConst.CLIENT_URL);
			String token = (String) session.getAttribute(AuthConst.TOKEN);

			if(StringUtils.isNotBlank(clientUrl))
			{
				ClientStorage.INSTANCE.set(token,clientUrl);
				rep.sendRedirect(clientUrl+"?"+AuthConst.TOKEN+"="+token);
				return;
			}

			if(!"/success".equals(uri))
			{
				rep.sendRedirect("/success");
				return;
			}

			chain.doFilter(request,response);
			return;
		}

		if("/".equals(uri) || "/login".equals(uri))
		{
			chain.doFilter(request,response);
			return;
		}

		rep.sendRedirect("/");
	}

	public void destroy()
	{
	}
}
