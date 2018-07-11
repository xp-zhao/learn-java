package com.xp.filter;

import com.xp.utils.CookieUtil;
import com.xp.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by xp-zhao on 2018/7/11.
 */
public class SessionFilter implements Filter
{
	@Override public void init(FilterConfig filterConfig) throws ServletException
	{
	}

	@Override public void doFilter(ServletRequest servletRequest , ServletResponse servletResponse ,
		FilterChain filterChain) throws IOException, ServletException
	{
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		String token = CookieUtil.readLoginToken(httpServletRequest);
		if(StringUtils.isNotBlank(token))
		{
			String user = (String) RedisUtil.get(token);
			if(StringUtils.isNotBlank(user))
			{
				RedisUtil.setEx(token , user , (long) 360);
			}
		}
		filterChain.doFilter(servletRequest,servletResponse);
	}

	@Override public void destroy()
	{
	}
}
