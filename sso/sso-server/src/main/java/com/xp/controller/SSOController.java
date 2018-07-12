package com.xp.controller;

import com.xp.common.AdminResult;
import com.xp.common.LoginUserContext;
import com.xp.common.RedisConst;
import com.xp.common.ResultConst;
import com.xp.model.User;
import com.xp.storage.SessionStorage;
import com.xp.utils.RedisUtil;
import com.xp.common.SSOConst;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by xp-zhao on 2018/5/14.
 */
@Controller
@RequestMapping("/sso")
public class SSOController
{
	@RequestMapping (value = "/login.do",method= RequestMethod.GET)
	public String login(HttpServletRequest request,Model model)
	{
		return "login";
	}
	@RequestMapping(value="login.do", method={RequestMethod.POST})
	@ResponseBody
	public Object login(HttpServletRequest request,HttpServletResponse response,HttpSession session, Model model,
		@RequestParam (value="username", required=false) String name,
		@RequestParam(value="password", required=false) String password) {
		if(StringUtils.isNotBlank(name) && StringUtils.isNotBlank(password)) {
			String backUrl = request.getParameter(SSOConst.CLIENT_URL);
			String token = UUID.randomUUID().toString();
			RedisUtil.setEx(session.getId() , name , RedisConst.REDIS_TOKEN_EXPIRE);
			// 建立全局会话
			session.setAttribute(SSOConst.IS_LOGIN,true);
			// 保存token，用于验证
			session.setAttribute(SSOConst.TOKEN, token);
			SessionStorage.INSTANCE.set(token, session);
			SessionStorage.INSTANCE.set(session.getId(),session);
			LoginUserContext.addUser(session.getId(),new User("userId",name));
			if(StringUtils.isNotBlank(backUrl)){
				try
				{
					response.sendRedirect(backUrl + "?"+SSOConst.TOKEN+ "=" + token);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			return new AdminResult(ResultConst.LOGIN_SUCCESS);
		}else{
			return new AdminResult(ResultConst.LOGIN_FAILED);
		}
	}

	@RequestMapping (value = "/getUserInfo.do",method= RequestMethod.GET)
	@ResponseBody
	public Object getUserInfo(HttpServletRequest request)
	{
		String sessionId = request.getSession().getId();
		User user = LoginUserContext.getUser(sessionId);
		if(user != null) {
			return new AdminResult(ResultConst.SUCCESS,user);
		}else{
			return new AdminResult(ResultConst.USER_NOT_LOGIN);
		}
	}
}
