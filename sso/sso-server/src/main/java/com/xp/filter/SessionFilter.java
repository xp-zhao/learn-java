package com.xp.filter;

import com.xp.common.SSOConst;
import com.xp.storage.ClientStorage;
import com.xp.utils.YamlUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * sso认证中心会话过滤
 * 
 */
public class SessionFilter implements Filter
{
	private List<String> FILTER_URLS;
	private List<String> LOGIN_URLS;

	public void destroy() {}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
		ServletException
	{
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		if(request.getRequestURI().indexOf(".") > 0)
		{
			chain.doFilter(req, res);
			return;
		}
		// 注销请求，放行
		if(FILTER_URLS.contains(uri))
		{
			chain.doFilter(req , res);
			return;
		}
		// 如果是客户端发起的请求（带有 callbackURL 参数），跳转回客户端
		String clientUrl = request.getParameter(SSOConst.CLIENT_URL);
		// 已经登录，放行
		if (session.getAttribute(SSOConst.IS_LOGIN) != null) {
			if (StringUtils.isNotBlank(clientUrl)) {
				// 获取登录认证中心时保存的 token
				String token = (String) session.getAttribute(SSOConst.TOKEN);
				// 存储子系统地址，用于注销
				ClientStorage.INSTANCE.set(token,clientUrl);
				// 重定向到客户端请求的地址，并附带 token（用于验证是否由认证中心发起的请求）
				response.sendRedirect(clientUrl + "?"+SSOConst.TOKEN+ "=" + token);
				return;
			}
			chain.doFilter(req, res);
			return;
		}
		// 登录请求，放行
		if (LOGIN_URLS.contains(uri)) {
			chain.doFilter(req, res);
			return;
		}
		// 其他请求，拦截
		response.sendRedirect("/sso-server/sso/login.do?"+SSOConst.CLIENT_URL+"="+clientUrl);
	}

	public void init(FilterConfig config) throws ServletException
	{
		FILTER_URLS = YamlUtil.getInstance().getList("filter");
		LOGIN_URLS = YamlUtil.getInstance().getList("login_urls");
	}
}
