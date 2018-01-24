package com.xp.sso.controller;

import com.xp.sso.constant.AuthConst;
import com.xp.sso.entity.User;
import com.xp.sso.service.UserService;
import com.xp.sso.storage.ClientStorage;
import com.xp.sso.storage.SessionStorage;
import com.xp.sso.util.HTTPUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by xp-zhao on 2018/1/24.
 */
@Controller
public class LoginController
{
	@Autowired
	private UserService userService;
	private UserService userS;

	@RequestMapping("/login")
	public String login(HttpServletRequest request,User input,Model model)
	{
		User user = userService.find(input);
		if(user == null)
		{
			model.addAttribute("error","username or password is wrong");
			return "redirect:/";
		}

		String token = UUID.randomUUID().toString();
		request.getSession().setAttribute(AuthConst.IS_LOGIN,true);
		request.getSession().setAttribute(AuthConst.TOKEN,token);

		SessionStorage.INSTANCE.set(token,request.getSession());

		String clientUrl = request.getParameter(AuthConst.CLIENT_URL);
		if(StringUtils.isNotBlank(clientUrl))
		{
			ClientStorage.INSTANCE.set(token,clientUrl);
			return "redirect:" + clientUrl + "?" + AuthConst.TOKEN + "=" + token;
		}
		return "redirect:/";
	}

	@RequestMapping ("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String token = request.getParameter(AuthConst.LOGOUT_REQUEST);

		// token存在于请求中，表示从客户端发起的注销；token存在于会话中，表示从认证中心发起的注销
		if (token != null && !"".equals(token)) {
			session = SessionStorage.INSTANCE.get(token);
		} else {
			token = (String) session.getAttribute(AuthConst.TOKEN);
		}

		if (session != null) {
			session.invalidate();
		}

		// 注销子系统
		List<String> list = ClientStorage.INSTANCE.get(token);
		if (list != null && list.size() > 0) {
			Map<String, String> params = new HashMap<String, String>();
			params.put(AuthConst.LOGOUT_REQUEST, token);
			for (String url : list) {
				HTTPUtil.post(url, params);
			}
		}

		return "redirect:/";
	}
}
