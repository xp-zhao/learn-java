package com.xp.filter;

import com.alibaba.fastjson.JSONObject;
import com.xp.common.SSOConst;
import com.xp.storage.AuthorizationStorage;
import com.xp.storage.SessionStorage;
import com.xp.utils.HTTPUtil;
import com.xp.utils.PropertiesUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xp-zhao on 2018/2/1.
 */
public class SSOFilter implements Filter
{
	private String SSO_SERVER_URL;
	private String SSO_SERVER_VERIFY_URL;
	private String SSO_SERVER_IP;

	public void init(FilterConfig filterConfig) throws ServletException
	{
		SSO_SERVER_IP = PropertiesUtil.getInstance().get("sso_server_address");
		SSO_SERVER_URL = MessageFormat.format(SSOConst.SSO_SERVER_URL,SSO_SERVER_IP);
		SSO_SERVER_VERIFY_URL = MessageFormat.format(SSOConst.SSO_SERVER_VERIFY_URL,SSO_SERVER_IP);
	}

	public void doFilter(ServletRequest req , ServletResponse res , FilterChain chain)
		throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		String authority = null;

		// 获取请求中的参数
		String params = request.getQueryString();
		// 获取当前请求的 uri
		String currentUri = request.getRequestURI();
		String currentUrl = currentUri.substring(request.getContextPath().length());
		//从认证中心发送的注销请求
//		String token = request.getParameter(SSOConstant.LOGOUT_REQUEST); //request.getParameter会导致后续获取不到参数中的值
		String token = getParamValue(params,SSOConst.LOGOUT_REQUEST);
		if(null != token && token.length() >0)
		{
			session = SessionStorage.INSTANCE.getSession(token);
			if (session != null)
			{
				AuthorizationStorage.INSTANCE.remove(session.getId());
				session.invalidate();
				return;
			}
		}
		if (session.getAttribute(SSOConst.IS_LOGIN) != null && (boolean)session.getAttribute(SSOConst.IS_LOGIN) == true) {
			chain.doFilter(req,res);
			return;
		}
		//请求中带有token，去sso-server验证token是否有效
		token = getParamValue(params,SSOConst.TOKEN);
		if(null != token && token.length() >0)
		{
//			token = request.getParameter(SSOConstant.TOKEN);
			// token 验证
			boolean verifyResult = this.verify(request, SSO_SERVER_VERIFY_URL,token);
			if (verifyResult) {
				// token 有效则建立局部会话
				session.setAttribute(SSOConst.IS_LOGIN,true);
				// 存储 session，用于注销子系统
				SessionStorage.INSTANCE.set(token,session);
				chain.doFilter(req, res);
				return;
			} else {
				System.out.println( "token is invalidate.");
			}
		}
		//跳转(重定向)至sso认证中心
		String callbackURL = request.getRequestURL().toString();
		StringBuilder url = new StringBuilder();
		url.append(SSO_SERVER_URL).append("?"+SSOConst.CLIENT_URL+"=").append(callbackURL);
		if(authority != null) {
			url.append("&authority=").append(authority);
		}
		response.sendRedirect(url.toString());
	}

	/**
	 * 判断参数中是否有指定的参数名称
	 * @param sources
	 * @param key
	 * @return
	 */
	public static String getParamValue(String sources,String key)
	{
		if(null == sources || sources.length() == 0)
		{
			return null;
		}
		int x = sources.indexOf(key+"=");
		if(x>=0)
		{
			String y = sources.substring(x+key.length()+1);
			if(y.indexOf("&")>0)
			{
				return y.substring(0, y.indexOf("&"));
			}
			else
			{
				return y;
			}
		}
		return null;
	}

	/**
	 * 到认证中心验证 token 是否有效
	 * @param request
	 * @param verifyUrl
	 * @param token
	 * @return
	 */
	private boolean verify(HttpServletRequest request, String verifyUrl, String token) {
		Map<String, String> params = new HashMap<>();
		params.put(SSOConst.TOKEN,token);
		params.put(SSOConst.SESSION_ID , request.getSession().getId());
		String result = HTTPUtil.post(request, verifyUrl,params);
		JSONObject ret = JSONObject.parseObject(result);
		if("000000".equals(ret.getString("code"))) {
			return true;
		}
		return false;
	}

	public void destroy()
	{
	}
}
